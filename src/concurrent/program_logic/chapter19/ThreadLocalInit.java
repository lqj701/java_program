package concurrent.program_logic.chapter19;

public class ThreadLocalInit {
    static ThreadLocal<Integer> local = new ThreadLocal() {
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    public static void main(String[] args) {
        System.out.println(local.get());
        local.set(200);
        local.remove();
        System.out.println(local.get());
    }
}
