package learning.jpa.lambda.test;

import com.google.common.base.Function;
import learning.jpa.lambda.bean.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Classname TestLambda5
 * @Description TODO
 * @Date 2020/8/18 11:34 上午
 * @Author z7-x
 */
public class TestLambda5 {

    /**
     * 补充说明
     * Java 中类的方法分为 "类方法"：即用static修饰，也叫静态方法 和 "实例方法":即没有用static修饰，也叫非静内态方法；
     */

    /**
     * 一、方法引用
     * Lambda 方法引用 :若Lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
     * （可以理解为方法引用是 Lambda 表达式的另一种表现形式）
     * 主要有三种引用格式
     * <p>
     * 语法格式一: 对象::实例方法名 | 对象.实例方法名
     * 语法格式二: 类::静态方法名
     * 语法格式三: 类::实例方法名
     * </p>
     * <p>
     * 注意： Lambda 体中调用方法的参数列表与返回值类型 要与 函数式接口中抽象方法的函数列表和返回值保持一致；
     * 若 Lambda 参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可是使用 类::实例方法名
     * <p>
     * <p>
     * 二、构造器方法引用：
     * 语法格式一: 类::new
     * <p>
     * 注意： 需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
     */

    //语法格式一：对象::实例方法名 | 对象.实例方法名
    @Test
    public void test1() {
        Consumer<String> consumer1 = (x) -> System.out.println(x);
        PrintStream ps = System.out;
        Consumer<String> consumer2 = ps::println;

        Consumer<String> consumer3 = System.out::println;
        consumer3.accept("abcdef");
    }

    @Test
    public void test2() {
        Employee employee = new Employee();
        Supplier<String> employeeSupplier = () -> employee.getName();
        System.out.println(employeeSupplier.get());

        Supplier<String> integerSupplier = employee::getName; //对象::实例方法名
        System.out.println(integerSupplier.get());
    }

    //语法格式二:类::静态方法名
    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        comparator.compare(1, 1);

        Comparator<Integer> compare = Integer::compare; //类::静态方法名
        int compare1 = compare.compare(1, 1);
        System.out.println(compare1);
    }

    //语法格式三: 类::实例方法名
    @Test
    public void test4() {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);

        BiPredicate<String, String> biPredicate1 = String::equals;
    }

    /**
     * 构造器引用
     */
    @Test
    public void test5() {
        Supplier<Employee> supplier = () -> new Employee(); //Lambda 表达式引用方式
        Employee employee = supplier.get();
        System.out.println(employee);

        Supplier<Employee> supplier1 = Employee::new;//构造器引用方式
        Employee employee1 = supplier1.get();
        System.out.println(employee1);

        Function<String, Employee> function = Employee::new;
        Employee employee2 = function.apply("谢中奇");//构造器引用方式:具体是调用有参还是无参的方法，取决于传入的参数列表个数
        System.out.println(employee2);

        Function<String, Employee> function1 = (x) -> new Employee(x);//与构造器不同的是需要传入参数
        Employee employee3 = function1.apply("谢中奇");
        System.out.println(employee3);
    }
}
