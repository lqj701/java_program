package concurrent.program_logic.chapter15.synchronized_usage;

public class Counter {
    private int count = 0;
    // 加volatile也不行，volatile只能保证内存可见性，不能保证操作的原子性;
    // private volatile static int count = 0;

    // synchronized 除了保证同步之外，还能保证内存可见性，因为在释放锁时，
    // 所有写入都会写入内存，获得锁时，会从内存读最新数据
    public synchronized void incr() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
