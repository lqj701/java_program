package concurrent.program_logic.chapter15;

public class Consumer extends Thread {
    MyBlockingQueue<String> queue;

    public Consumer(MyBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String task = queue.take();
                System.out.println("handle task " + task);
                Thread.sleep((int) Math.random() * 100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
