package concurrent.program_logic.chapter16;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private volatile int count;
    private final Lock lock = new ReentrantLock();

    public void incr() {
        lock.lock();

        try {
            count++;
        } finally {

        }
    }

    public int getCount() {
        return count;
    }
}
