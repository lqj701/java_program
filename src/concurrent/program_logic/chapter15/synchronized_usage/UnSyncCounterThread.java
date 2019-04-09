package concurrent.program_logic.chapter15.synchronized_usage;

public class UnSyncCounterThread extends Thread {
    private static volatile int counter = 0;

    private UnSyncCounterThread() {

    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 1000;
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            // new出了不同的线程对象，也就是说其实每个UnSyncCounterThread对象都获得了各自的对象锁，
            // 都可以执行各自的run方法，即使run加synchronized也不能实现同步，
            // 解决办法是不去继承Thread类，通过实现Runnable接口的办法
            threads[i] = new UnSyncCounterThread();
            threads[i].start();
            System.out.println(threads[i].getName());
        }
        for (int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(counter);
    }
}
