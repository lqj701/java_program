package io.netty_definitive_guide.chapter2.aio;

import java.util.concurrent.*;

public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;

        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();

        ExecutorService executor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));

    }
}
