package concurrent.program_logic.chapter15.thread_collaboration;

public class ProduceConsumerDemo {
    public static void main(String[] args) {
        MyBlockingQueue<String> queue = new MyBlockingQueue<>(10);

        new Producer(queue).start();
        new Consumer(queue).start();
    }
}
