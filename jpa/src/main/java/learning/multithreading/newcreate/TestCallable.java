package learning.multithreading.newcreate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname TestCallable
 * @Description TODO jdk 5.0  新增创建线程池方式
 * @Date 2020/9/10 9:03 上午
 * @Author z7-x
 */
public class TestCallable {
    /**
     * 方式一：实现Callable接口
     * 与使用Runnable接口相比，Callable更加强大一些
     * 与Runnable 相比，可以有返回值
     * 方法可以抛异常
     * 支持范型返回值
     * 需要借助FutureTask类，比如获取返回结果
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建Callable接口实现类对象
        NewCreateWay newCreateWay = new NewCreateWay();
        // 将此Callable接口实现累对象作为传递到FutureTask的构造器中，创建FutureTask对象
        FutureTask futureTask = new FutureTask(newCreateWay);
        // 将FutureTask对象作为参数传递到Thread类的构造器中，创建Thread并调用start()方法
        new Thread(futureTask).start();

        // 获取Callable call()方法的返回值
        // get()返回值即为futureTask构造器参数Callable实现类重写的call()的返回值
        Object value = futureTask.get();
        System.out.println(value);
    }
}

class NewCreateWay implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}