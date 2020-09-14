package learning.multithreading.lock;

/**
 * @Classname TestBank
 * @Description TODO 使用同步机制，将单例模式中的懒汉式写成线程安全的
 * @Date 2020/9/7 2:18 下午
 * @Author z7-x
 */
public class TestBank {
    /**
     * 使用同步机制，将单例模式中的懒汉式写成线程安全的
     */

    public static void main(String[] args) {

    }
}


class Bank {

    private Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() {
        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二:优先选择高效率
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
