package learning.multithreading.service;

/**
 * @Classname TestRunable
 * @Description TODO
 * @Date 2020/8/31 4:08 下午
 * @Author z7-x
 */
public class TestRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("good time");
        }
    }

    public static void main(String[] args) {
        TestRunnable testRunnable = new TestRunnable();
        new Thread(testRunnable).start();
    }
}
