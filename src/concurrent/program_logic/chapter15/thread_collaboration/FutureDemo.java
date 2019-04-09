package concurrent.program_logic.chapter15.thread_collaboration;

import java.util.concurrent.Callable;

public class FutureDemo {
    public static void main(String[] args) {
        MyExecutor executor = new MyExecutor();

        // 子任务
        Callable<Integer> subTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int millis = (int) (1000);
                Thread.sleep(millis);
                return millis;
            }
        };

        // 异步调用，返回MyFuture对象
        MyFuture<Integer> future = executor.execute(subTask);

        try {
            Integer result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
