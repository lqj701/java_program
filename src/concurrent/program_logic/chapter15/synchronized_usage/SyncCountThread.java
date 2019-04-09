package concurrent.program_logic.chapter15.synchronized_usage;

public class SyncCountThread implements Runnable {

    private static int counter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 1000;
        Thread[] threads = new Thread[num];
        SyncCountThread SyncCountThread = new SyncCountThread();
        for (int i = 0; i < num; i++) {
            threads[i] = new Thread(SyncCountThread);
            threads[i].start();
            System.out.println(threads[i].getName());
        }
        for (int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(counter);
    }
}
