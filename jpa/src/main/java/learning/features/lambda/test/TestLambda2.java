package learning.features.lambda.test;

import learning.features.lambda.service.impl.MyFunInterface;
import learning.features.lambda.service.impl.MyFunInterface2;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Classname TestLambda2
 * @Description TODO
 * @Date 2020/8/16 1:38 下午
 * @Author z7-x
 */
public class TestLambda2 {

    /**
     * 一、Lambda 表达式基础语法: Java8中引入新的操作符" ->"  该操作符称为箭头操作符 或 Lambda操作符
     * 左侧: Lambda 表达式对应接口的参数列表
     * 右侧：Lambda 表达式中所需执行的功能，即Lambda体
     * <p>
     * 语法格式一：若无参数 无返回值
     * （）->System.out.println("Hello Lambda");
     * <p>
     * 语法格式二：若有一个参数 无返回值
     * （x）-> System.out.println(x);
     * <p>
     * 语法格式三：若只有一个参数，小括号可以省略不写
     * x-> System.out.println(x);
     * <p>
     * 语法格式四：若有两个以上的参数，并且Lambda体中有多条语句，要写{},有返回值
     * <p>
     * 语法格式五：若Lambda体中只有一条语句，return 和{} 都可以省略不写
     * <p>
     * 语法格式六：Lambda表达式中参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即"类型推断"
     * <p>
     * 二、Lambda 表达式需要"函数式接口"的支持
     * 函数式接口：接口中只能有一个抽象方法的接口，称为函数式接口，可以使用@FunctionalInterface注解修饰
     * 可以检查是否是函数式接口
     */

    @Test
    public void Test1() {
        Runnable runnable = () -> System.out.println("语法格式一");
        runnable.run();
    }

    @Test
    public void Test2() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("语法格式二");
    }

    @Test
    public void Test3() {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("语法格式三");
    }

    @Test
    public void Test4() {
        Comparator<Integer> comparable = (x, y) -> {
            System.out.println("语法格式四:" + Integer.compare(x, y));
            return Integer.compare(x, y);
        };
        comparable.compare(10, 20);
    }

    @Test
    public void Test5() {
        Comparator<Integer> comparable = (x, y) -> Integer.compare(x, y);
        comparable.compare(10, 20);
    }

    @Test
    public void Test6() {
        //Lambda 左侧的参数列表 (Integer x, Integer y) 的Integer可省略
        Comparator<Integer> comparable = (Integer x, Integer y) -> Integer.compare(x, y);
        comparable.compare(10, 20);
    }

    @Test
    public void Test7() {
        String string = strHandle("z7zz", item -> item.toUpperCase());
        System.out.println(string);
    }

    //处理字符串
    public String strHandle(String str, MyFunInterface myFunInterface) {
        return myFunInterface.getValue(str);
    }

    @Test
    public void Test8() {
        countValue(1L, 2L, (v1, v2) -> v1 + v2);
        countValue(1L, 2L, (v1, v2) -> v1 * v2);
    }

    //处理两个long类型计算
    public void countValue(Long v1, Long v2, MyFunInterface2<Long, Long> myFunInterface2) {
        System.out.println(myFunInterface2.getValue(v1, v2).toString());
    }

    //内置常用接口

}
