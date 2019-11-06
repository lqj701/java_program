package concurrent.program_logic.chapter15.thread_collaboration.my_count_down_latch;

public class RacerWithLatchDemo {
    static class Racer extends Thread {
        MyLatch latch;

        public Racer(MyLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                this.latch.await();
                System.out.println("start run " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        MyLatch latch = new MyLatch(2);

        Thread[] racers = new Thread[num];

        for (int i = 0; i < num; i++) {
            racers[i] = new Racer(latch);
            racers[i].start();
        }

        Thread.sleep(1000);
        latch.countDown();
        latch.countDown();
    }
}
