package concurrent.program_logic.chapter15.thread_collaboration.my_future;

public interface MyFuture<V> {
    V get() throws Exception;
}
