package learning.multithreading.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname TestCallable
 * @Description TODO
 * @Date 2020/8/31 4:31 下午
 * @Author z7-x
 */
public class TestCallable implements Callable {
    @Override
    public Object call() throws Exception {
        return "Hello Callable!";
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(new TestCallable());
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
