package learning.features.lambda.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Classname TestLambda4
 * @Description TODO
 * @Date 2020/8/18 10:01 上午
 * @Author z7-x
 */
public class TestLambda4 {

    /**
     * Java8 内置的四大核心函数式接口
     * <p>
     * Consumer<T> :   消费型接口
     *                 void accept(T t);
     * Supplier<T> :   供给型接口
     *                 T get();
     * Function<T,R> : 函数型接口
     *                 R apply(T t) :
     * Predicate<T>:   断言型接口
     *                 boolean test(T t);
     */

    @Test
    public void test1() {
        happy(200.00, (money) -> System.out.println("消费金额:" + money));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test2() {
        List<Integer> list = gteNumList(10, () ->  (int)Math.random() * 99);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);
        }
    }

    //需求：产生指定个数整数，并放入集合中
    public List<Integer> gteNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = sup.get();
            list.add(integer);
        }
        return list;
    }

    @Test
    public void test3() {
        Integer s1 = strHandler("szqsds", (s -> s.length()));
        System.out.println(s1);
    }

    //需求：用于处理字符串
    public Integer strHandler(String str,Function<String,Integer> function){
        Integer apply = function.apply(str);
        return apply;
    }

    @Test
    public void test4() {
        List<String> strings = Arrays.asList(
                new String("saa"),
                new String("docker"),
                new String("pass")
        );
        List<String> strings1 = filterStr(strings, (param) -> param.length() > 4);
        strings1.forEach(s -> System.out.println(s));
    }

    //需求：将满足条件的字符串放入集合中
    public List<String> filterStr(List<String> str, Predicate<String> stringPredicate) {
        List<String> strings = new ArrayList<>();
        str.stream().forEach(s -> {
            if (stringPredicate.test(s)) {
                strings.add(s);
            }
        });
        return strings;
    }

}
