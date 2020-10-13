package learning.multithreading.lock.MethodsC;

import learning.multithreading.lock.MethodsA.TestImpRunnable;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname TestLock
 * @Description TODO 解决线程安全问题 方式三 Lock锁
 * @Date 2020/9/7 4:33 下午
 * @Author z7-x
 */
public class TestLock implements Runnable {
    private static int ticket = 100;
    private ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            //调用lock()
            reentrantLock.lock();

            try {
                Thread.sleep(100);
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票,票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } catch (Exception e) {
                e.getMessage();
            }finally {
                //调用解锁方法
                reentrantLock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        TestLock testLock = new TestLock();

        Thread thread1 = new Thread(testLock);
        Thread thread2 = new Thread(testLock);
        Thread thread3 = new Thread(testLock);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
