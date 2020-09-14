package learning.multithreading.lock;

/**
 * @Classname TestAccount
 * @Description TODO 多线程应用实例
 * @Date 2020/9/7 5:50 下午
 * @Author z7-x
 */
public class TestAccount {
    /**
     * 需求：银行有一个账户，有两个储户分别向同一个账户存3000块钱，每次存1000，操作3次，每次存完打印账户余额
     * <p>
     * 分析：
     * 1、是否是多线程问题？ 是，有两个储户
     * 2、是否有共享数据？ 有，同一个账户（或账户余额）
     * 3、是否有线程安全问题？ 有
     * 4、需要如何考虑解决线程安全问题？ 同步机制：三种方式
     * </p>
     */

    public static void main(String[] args) {
        Account account = new Account(0);

        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);

        customer1.setName("储户一");
        customer2.setName("储户二");

        customer1.start();
        customer2.start();
    }
}

class Account {//账户
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amt) {//存钱
        if (amt > 0) {
            balance += amt;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.getMessage();
            }
            System.out.println(Thread.currentThread().getName() + ":存钱成功！余额为：" + balance);
        }
    }
}

class Customer extends Thread {//储户
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}

