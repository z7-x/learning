package learning.multithreading.service;

import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * @Classname TestThreadMethod
 * @Description TODO
 * @Date 2020/9/1 10:33 上午
 * @Author z7-x
 */
public class TestThreadMethod {
    /**
     *
     * Thread中常用的方法:
     * 1、start();               启动线程，调用当前线程的run()方法
     * 2、run();                 通过重写Thread中的run()方法,将创建的线程要执行的操作声明在此方法中
     * 3、currentThread();       静态方法，返回执行当前代码的线程
     * 4、getName();             返回当前线程的名称
     * 5、setName();             设置当前线程的名称
     * 6、yield();               释放当前CPU的执行权
     * 7、join();                在线程A中调用线程B的join()方法，此时线程A就会进入阻塞状态，直到线程B完全执行完以后，线程A才结束阻塞状态
     * 8、stop();                当执行此方法时，强行结束当前线程
     * 9、sleep();               阻塞线程，让当前线程睡眠指定的毫秒数
     * 10、isAlive();            判断当前线程还是否存活
     */

    public static void main(String[] args) {
        
    }
}
