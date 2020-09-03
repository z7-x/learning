package learning.multithreading.service;

/**
 * @Classname TestWindows2
 * @Description TODO
 * @Date 2020/9/2 4:45 下午
 * @Author z7-x
 */
public class TestWindows2 {
    /**
     * 需求：创建三个窗口卖票，总票数为100张
     * <p>
     * 开发过程中，优先使用Runnable接口方式
     * 原因1、实现的方式没有类的单继承的局限性
     * 原因2、实现的方式更适合来处理多个线程有共享数据的情况
     * <p>
     * 相同点：两种方式都需要重写run()方法，将线程要执行的逻辑声明在run()中
     */
    public static void main(String[] args) {
        ExThread2 exThread2 = new ExThread2();

        Thread thread1 = new Thread(exThread2);
        Thread thread2 = new Thread(exThread2);
        Thread thread3 = new Thread(exThread2);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class ExThread2 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}





