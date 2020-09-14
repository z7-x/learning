package learning.multithreading.lock.MethodsB;

import lombok.SneakyThrows;

/**
 * @Classname TestSynMethodRunnable
 * @Description TODO 使用同步放法实现Runnable接口,解决线程安全问题
 * @Date 2020/9/7 10:14 上午
 * @Author z7-x
 */
public class TestSynMethodRunnable implements Runnable {
    /**
     * 关于同步方法的总结：
     * 1、同步方法仍然涉及到同步监视器，只是不需要我们显示声明。
     * 2、非静态的同步方法，同步监视器是:this
     *    静态的同步方法，同步监视器是：当前类本身
     */
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    @SneakyThrows
    public synchronized void show() {//同步监视器：this
        if (ticket > 0) {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
            ticket--;
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        TestSynMethodRunnable testSynMethodRunnable = new TestSynMethodRunnable();

        Thread thread1 = new Thread(testSynMethodRunnable);
        Thread thread2 = new Thread(testSynMethodRunnable);
        Thread thread3 = new Thread(testSynMethodRunnable);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
