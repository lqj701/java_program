package concurrent.concurrent_art.chapter4.thread_pool;

import java.io.File;

public class HttpServerDemo {
    public static void main(String[] args) throws Exception {
        SimpleHttpServer.setBasePath(
                System.getProperty("user.dir") + File.separator + "src\\concurrent\\concurrent_art\\chapter4");
        SimpleHttpServer.start();
    }
}
