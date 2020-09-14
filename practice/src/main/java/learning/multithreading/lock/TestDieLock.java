package learning.multithreading.lock;

/**
 * @Classname TestDieLock
 * @Description TODO 演示线程的死锁问题
 * @Date 2020/9/7 4:02 下午
 * @Author z7-x
 */
public class TestDieLock {
    public static void main(String[] args) {
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();

        new Thread() {
            @Override
            public void run() {
                synchronized (buffer1) {
                    buffer1.append("a");
                    buffer2.append("b");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.getMessage();
                    }

                    synchronized (buffer2) {
                        buffer1.append("1");
                        buffer2.append("2");

                        System.out.println(buffer1);
                        System.out.println(buffer2);
                    }
                }
            }
        }.start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        synchronized (buffer2) {
                            buffer1.append("c");
                            buffer2.append("d");

                            try {
                                Thread.sleep(100);
                            } catch (Exception e) {
                                e.getMessage();
                            }

                            synchronized (buffer1) {
                                buffer1.append("3");
                                buffer2.append("4");

                                System.out.println(buffer1);
                                System.out.println(buffer2);
                            }
                        }
                    }
                }
        ).start();
    }
}
