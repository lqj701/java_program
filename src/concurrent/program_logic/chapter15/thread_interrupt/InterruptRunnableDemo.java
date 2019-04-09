package concurrent.program_logic.chapter15.thread_interrupt;

public class InterruptRunnableDemo extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

        }
        System.out.println("done ");
    }

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(isInterrupted());
                }
            }

        };
        t.start();

        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }


}
