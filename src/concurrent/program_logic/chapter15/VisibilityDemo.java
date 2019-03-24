package concurrent.program_logic.chapter15;

public class VisibilityDemo {
    private static volatile boolean shutdown = false;

    static class HelloThread extends Thread {
        @Override
        public void run() {
            while (!shutdown) {

            }
            System.out.println("exit hello");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new HelloThread().start();
        Thread.sleep(1000);
        shutdown = true;
        System.out.println("exit main");
    }

}
