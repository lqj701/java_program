package io.netty_definitive_guide.chapter2.psudo_async;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import io.netty_definitive_guide.chapter2.sync.TimeServerHandler;

public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;

        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port : " + port);

            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 10000);

            while (true) {
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
