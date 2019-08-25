package spring.spring_mvc_in_action.chapter4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();

        ssc.socket().bind(new InetSocketAddress(8080));

        ssc.configureBlocking(false);

        Selector selector = Selector.open();

        ssc.register(selector, SelectionKey.OP_ACCEPT);

        Handler handler = new Handler(1024);

        while (true) {
            if (selector.select(3000) == 0) {
                System.out.println("等待请求超时.....");
                continue;
            }

            System.out.println("处理请求......");

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                try {
                    if (key.isAcceptable()) {
                        handler.handleAccept(key);
                    }

                    if (key.isReadable()) {
                        handler.handleRead(key);
                    }
                } catch (IOException e) {
                    keyIterator.remove();

                    continue;
                }
                keyIterator.remove();
            }
        }
    }


    private static class Handler {
        private int bufferSize = 1024;
        private String localCharset = "UTF-8";

        public Handler() {
        }

        public Handler(int bufferSize) {
            this(bufferSize, null);
        }

        public Handler(String LocalCharset) {
            this(-1, LocalCharset);
        }

        public Handler(int bufferSize, String localCharset) {
            if (bufferSize > 0) {
                this.bufferSize = bufferSize;
            }

            if (localCharset != null) {
                this.localCharset = localCharset;
            }
        }

        public void handleAccept(SelectionKey key) throws IOException {
            SocketChannel sc = ((ServerSocketChannel) key.channel()).accept();
            sc.configureBlocking(false);
            sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        }

        public void handleRead(SelectionKey key) throws IOException {
            SocketChannel sc = (SocketChannel) key.channel();

            ByteBuffer buffer = (ByteBuffer) key.attachment();

            buffer.clear();

            if (sc.read(buffer) == 1) {
                sc.close();
            } else {
                buffer.flip();

                String receivedString = Charset.forName(localCharset).newDecoder().decode(buffer).toString();

                System.out.println("received from client: " + receivedString);

                String sendString = "received data: " + receivedString;

                buffer = ByteBuffer.wrap(sendString.getBytes(localCharset));

                sc.write(buffer);
                sc.close();
            }
        }
    }
}
