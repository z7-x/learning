package learning.multithreading.lock.MethodsA;

import lombok.SneakyThrows;

/**
 * @Classname TestExtendsThread
 * @Description TODO 使用同步代码块实现Runnable接口，解决线程安全问题
 * @Date 2020/9/4 4:59 下午
 * @Author z7-x
 */
public class TestImpRunnable implements Runnable{

    /**
     * 需求：创建三个窗口卖票，总票数为100张，使用实现Runnable接口方式
     *
     * 如何解决线程安全问题（Runnable）
     *  方式一、synchronized (同步监视器){
     *      //需要被同步的代码
     *  }
     *  说明：1、操作共享数据的代码，即为需要被同步的数据； --->代码块不能包含代码多了。也不能包好少类；
     *       2、共享数据：多个线程共同操作的变量。比如 ticket 就是共享数据
     *       3、同步监视器：俗称："锁"。 任何一个类的对象，都可充当锁,当前类直接用this即可
     *          要求：多个线程必须要公用同一把锁
     *
     *  方式二、同步方法（使用同步代码块解决继承Thread类的方式的线程安全问题）
     *  共享锁是用static
     *  如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明为同步的。
     *
     *  好处：同步的方式，解决了线程的安全问题。
     *  缺点：操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程。
     */

    private int ticket = 100;
    private Object object = new Object();//多个线程必须要公用同一把锁

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            synchronized (this) {//方式一：此时的this:当前对象  方式二：new 一个对象
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
        TestImpRunnable exThread2 = new TestImpRunnable();

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


