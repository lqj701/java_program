package concurrent.program_logic.chapter15.thread_collaboration;

public class WaitThread extends Thread {
    private volatile boolean fire = false;

    @Override
    public void run() {
        try {
            synchronized (this) {
                while (!fire) {
                    wait();
                }
            }
            System.out.println("fired");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void fire() {
        this.fire = fire;
        notify();
    }

    public static void main(String[] args) throws InterruptedException {
        WaitThread waitThread = new WaitThread();
        waitThread.start();
        Thread.sleep(1000);

        System.out.println("fire");
        waitThread.fire();
    }
}
