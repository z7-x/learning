package learning.multithreading.newcreate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname TestExecutors
 * @Description TODO jdk 5.0  新增创建线程池方式
 * @Date 2020/9/10 9:33 上午
 * @Author z7-x
 */
public class TestExecutors {
    /**
     * 方式二：使用线程池
     * 实际开发过程中，推荐使用实现Runnable接口
     */
    public static void main(String[] args) {
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        ExecutorService threadPool2 = Executors.newCachedThreadPool();
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int task = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j <= 10; j++) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()
                                + " is looping of " + j + " for  task of "
                                + task);
                    }
                }
            });
        }
    }
}
