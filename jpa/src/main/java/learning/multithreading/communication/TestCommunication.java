package learning.multithreading.communication;

import lombok.SneakyThrows;

/**
 * @Classname TestCommunication
 * @Description TODO 线程通信案例
 * @Date 2020/9/8 2:57 下午
 * @Author z7-x
 */
public class TestCommunication {
    /**
     * 需求：使用两个线程打印1-100。线程1、线程2 交替打印
     h
     * 涉及到三个方法：wait():一旦执行此方法，当前线程就会进入阻塞状态，并释放同步监视器
     * notify: 一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，就唤醒优先级高的那个
     * notifyAll:一旦执行此方法，就会唤醒被wait的所有线程
     *
     * 说明：wait()、notify()、notifyAll()这三个方法必须使用在同步代码块或同步方法中
     *      wait()、notify()、notifyAll()这三个方法必须使用在同步代码块或同步方法中的同步监视器
     *      wait()、notify()、notifyAll()这三个方法都是定义在java.lang.Object类中
     */
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

class Number implements Runnable {
    private int number = 1;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notifyAll();//唤醒所有线程
                if (number <= 100) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    wait();//使得调用wait()方法线程进入阻塞状态
                } else {
                    break;
                }
            }
        }
    }
}
