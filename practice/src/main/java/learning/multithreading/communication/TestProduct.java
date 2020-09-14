package learning.multithreading.communication;

/**
 * @Classname TestProduct
 * @Description TODO 线程通信的应用：经典例题 （生产者/消费者问题）
 * @Date 2020/9/8 6:23 下午
 * @Author z7-x
 */
public class TestProduct {

    /**
     * 需求：生产者（Product） 将产品交给店员（Clerk）,而消费者（Customer）从店员处取走产品，
     * 店员一次只能持有固定数量的产品（比如：20），如果生产者试图生产更多的产品，店员会叫生产者停一下，
     * 如果店中有空位放产品了再通知生产者继续生产，如果店中没有产品了，店员会告诉消费者等一下，如果店里有产品了再通知消费者来取走产品
     */
}
