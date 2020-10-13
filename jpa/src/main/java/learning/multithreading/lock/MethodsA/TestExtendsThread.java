package learning.multithreading.lock.MethodsA;

import lombok.SneakyThrows;

/**
 * @Classname TestExtendsThread
 * @Description TODO 使用同步代码块解决继承Thread类的方式的线程安全问题
 * @Date 2020/9/4 4:59 下午
 * @Author z7-x
 */
public class TestExtendsThread extends Thread {
    /**
     * 使用同步代码块解决继承Thread类的方式的线程安全问题
     * 需求：创建三个窗口卖票，总票数为100张，使用继承Thread方式
     * 说明: 在继承TThread类创建多线程的方式中，慎用this充当同步监视器，看this是否唯一；可以考虑使用当前类来充当。
     */
    private static int ticket = 100;
    private static Object object = new Object();

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
//            synchronized (object) {//正确的
            synchronized (TestExtendsThread.class) {//正确的
//                synchronized (this) {//错误的，此时this代表着thread1，thread2，thread3三个对象
                if (ticket > 0) {

                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
                    ticket--;

                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        TestExtendsThread thread1 = new TestExtendsThread();
        TestExtendsThread thread2 = new TestExtendsThread();
        TestExtendsThread thread3 = new TestExtendsThread();

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }


}






