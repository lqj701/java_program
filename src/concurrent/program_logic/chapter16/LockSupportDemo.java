package concurrent.program_logic.chapter16;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                LockSupport.park();
                System.out.println("exit");
            }
        };

        t.start();
        Thread.sleep(1000);
        LockSupport.unpark(t);
    }
}
