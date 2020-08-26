package learning.features.stream.test;

import learning.features.lambda.bean.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
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

    private static List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
    private static Integer[] integers1 = new Integer[]{1, 2, 3, 4, 5};

    public static List<String> strings = Arrays.asList("dd", "aaa", "bbb", "ccc");


    @Test
    public void test1() {
        PrintStream out = System.out;
        employees.stream().forEach(out::println);


        List<String> collect = strings.stream().map(s -> {
            return s.toUpperCase();
        }).collect(Collectors.toList());
    }


    //需求：给定一个数字列表，如何返回一个由每个数的平方构成的列表
    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        integers.stream().forEach(integer -> list.add(integer * integer));
        list.forEach(System.out::println);

        Arrays.stream(integers1).map(integer -> integer * integer).forEach(System.out::println);

        Optional<Integer> reduce = integers.stream()
                .map((e) -> 1)
                .reduce((Integer::sum));
        System.out.println("流中的总个数：" + reduce.get());

    }

    @Test
    public void test3() {
        Instant start = Instant.now();

        OptionalLong reduce = LongStream.rangeClosed(0, 100L)
                .parallel()
                .reduce(Long::sum);
        System.out.println(reduce.getAsLong());

        Instant end = Instant.now();
        System.out.println("消耗时间：" + Duration.between(start, end).toMillis() + "ms");
    }

    //映射map与flatMap
    @Test
    public void test4() {
        employees.stream().map(Employee::getName).forEach(System.out::println);

        //map
        Stream<Stream<Character>> streamStream = employees.stream()
                .map(TestStream::filterCharacter)
                .distinct();
        streamStream.forEach(stream -> {
            stream.forEach(System.out::println);
        });

        //flatMap
        Stream<Character> characterStream = employees.stream()
                .flatMap(TestStream::filterCharacter);
        characterStream.forEach(System.out::println);

    }

    public static Stream<Character> filterCharacter(Employee employee) {
        List<Character> characters = new ArrayList<>();
        for (Character character : employee.getName().toCharArray()) {
            characters.add(character);
        }
        return characters.stream();
    }
}
