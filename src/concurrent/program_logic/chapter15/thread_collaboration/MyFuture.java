package concurrent.program_logic.chapter15.thread_collaboration;

public interface MyFuture<V> {
    V get() throws Exception;
}
