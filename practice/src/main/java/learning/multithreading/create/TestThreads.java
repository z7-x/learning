package learning.multithreading.create;

/**
 * @Classname TestThreads
 * @Description TODO
 * @Date 2020/9/1 10:04 上午
 * @Author z7-x
 */
public class TestThreads {
    /**
     * 需求：创建两个分线程，其中一个遍历100以内的偶数，另一个遍历100以内的奇数
     *
     * @param args
     */
    public static void main(String[] args) {
//        Thread1 thread1 = new Thread1();
//        Thread2 thread2 = new Thread2();
//
//        thread1.start();
//        thread2.start();

        //创建Thread类匿名子类的方式
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
