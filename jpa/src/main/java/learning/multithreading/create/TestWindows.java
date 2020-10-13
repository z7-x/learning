package learning.multithreading.create;

/**
 * @Classname TestWindows
 * @Description TODO
 * @Date 2020/9/2 2:49 下午
 * @Author z7-x
 */
public class TestWindows {
    /**
     * 需求：创建三个窗口卖票，总票数为100张
     *
     *
     */
    public static void main(String[] args) {
        ExThread thread1 = new ExThread();
        ExThread thread2 = new ExThread();
        ExThread thread3 = new ExThread();

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}


class ExThread extends java.lang.Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(this.getName() + "卖票：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}