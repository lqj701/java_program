package concurrent.program_logic.chapter16;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitThread extends Thread {
    private volatile boolean fire = false;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            try {
                while (!fire) {
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
            Thread.interrupted();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fire() {
        lock.lock();
        try {
            this.fire = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitThread waitThread = new WaitThread();
        waitThread.start();
        Thread.sleep(1000);
        System.out.println("fire");
        waitThread.fire();
    }
}
