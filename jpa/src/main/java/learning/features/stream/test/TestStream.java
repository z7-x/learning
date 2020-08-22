package learning.features.stream.test;

import learning.features.lambda.bean.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname StreamAPITest
 * @Description TODO
 * @Date 2020/8/21 4:04 下午
 * @Author z7-x
 */
public class TestStream {

    public static List<Employee> employees = Arrays.asList(
            new Employee("张三", 22, 9999.99),
            new Employee("李四", 23, 2222.22),
            new Employee("王五", 22, 7777.77),
            new Employee("赵六", 26, 6666.66),
            new Employee("田七", 24, 5555.55)
    );

    public static List<String> strings = Arrays.asList("dd", "aaa", "bbb", "ccc");


    @Test
    public void test1() {
        PrintStream out = System.out;
        employees.stream().forEach(out::println);


        List<String> collect = strings.stream().map(s -> {
            return s.toUpperCase();
        }).collect(Collectors.toList());
    }


    @Test
    public void test2() {
        strings.stream().sorted().forEach((x) -> System.out.println(x));
    }


}
