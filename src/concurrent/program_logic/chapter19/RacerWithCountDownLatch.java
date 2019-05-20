package concurrent.program_logic.chapter19;

import java.util.concurrent.CountDownLatch;

/**
 * begin at the same time by using CountDownLatch
 */
public class RacerWithCountDownLatch {
    static class Racer extends Thread {
        CountDownLatch latch;

        public Racer(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                // begin at latch.getCount() == 0
                this.latch.await();
                System.out.println(latch.getCount());
                System.out.println(getName() + " start run " + System.currentTimeMillis());
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        CountDownLatch latch = new CountDownLatch(1);
        Thread[] racers = new Thread[num];
        for (int i = 0; i < num; i++) {
            racers[i] = new Racer(latch);
            racers[i].start();
        }
        Thread.sleep(1000);
        latch.countDown();
    }
}
