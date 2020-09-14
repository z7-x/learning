package learning.multithreading.lock.MethodsB;

import lombok.SneakyThrows;

/**
 * @Classname TestSynExtendsThread
 * @Description TODO  使用同步方法解决继承Thread类的方式的线程安全问题
 * @Date 2020/9/7 11:07 上午
 * @Author z7-x
 */
public class TestSynExtendsThread extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    @SneakyThrows
    public static synchronized void show(){//同步监视器： TestSynExtendsThread.class
//    public synchronized void show() {//同步监视器thread1，thread2，thread3 此种解决方法是错误的
        if (ticket > 0) {

            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
            ticket--;

        }
    }

    public static void main(String[] args) {

        TestSynExtendsThread thread1 = new TestSynExtendsThread();
        TestSynExtendsThread thread2 = new TestSynExtendsThread();
        TestSynExtendsThread thread3 = new TestSynExtendsThread();

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
