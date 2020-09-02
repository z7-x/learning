package learning.multithreading.service;

/**
 * @Classname Thread
 * @Description TODO
 * @Date 2020/8/28 3:42 下午
 * @Author z7-x
 */
public class TestThread {

    public static void main(String[] args) {
        MyThread t = new MyThread();
        //1、启动当前线程start();  2、调用当前线程的run();
        t.start();
        //问题一：能不能直击通过调用run()方法的方式启动线程
//        t.run();
        //问题二: 再启动一个线程，遍历100以内的偶数
//        t.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("主线程" + Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
