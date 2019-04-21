package io.netty_definitive_guide.chapter2.nio;

public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);

        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
