package learning.features.time.test;

import learning.features.time.service.DateFormatThreadLocal;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Classname TestSimpleDateFormat
 * @Description TODO
 * @Date 2020/8/26 11:01 上午
 * @Author z7-x
 */
public class TestSimpleDateFormat {
    /**
     * 传统格式存在线程池安全问题
     * 解决方法： 上锁
     * 方法一、同步代码块
     * 语法：
     * synchronized(同步锁){
     * //需要同步操作的代码
     * }
     * <p>
     * 方法二、同步函数
     * 使用synchronized修饰的方法,就叫做同步方法,保证A线程执行该方法的时候,其他线程只能在方法外等着.
     * <p>
     * 方法三、同步锁
     * 在Lock接口中lock方法和unLock方法分别是获取锁和释放锁。
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> callable = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return simpleDateFormat.parse("20200825");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);//创建一个长度为10的线程池

        List<Future<Date>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(pool.submit(callable));
        }

        for(Future<Date> s:futures){
            System.out.println(s.get());//存在线程安全问题
        }
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {//上锁解决线程安全问题

        Callable<Date> callable = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return DateFormatThreadLocal.convert("20200825");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);//创建一个长度为10的线程池

        List<Future<Date>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(pool.submit(callable));
        }

        for(Future<Date> s:futures){
            System.out.println(s.get());//存在线程安全问题
        }

        pool.shutdown();

    }
}
