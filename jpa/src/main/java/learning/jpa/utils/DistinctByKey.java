package learning.jpa.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Classname DistinctByKey
 * @Description TODO
 * @Date 2020/11/5 3:45 下午
 * @Author z7-x
 */

/**
 * Stream 去除重复数据
 * for example:
 *  public static List<Employee> employees = Arrays.asList(
 *             new Employee("张三", 22, 9999.99),
 *             new Employee("李四", 23, 2222.22),
 *             new Employee("王五", 22, 7777.77),
 *             new Employee("赵六", 26, 6666.66),
 *             new Employee("赵六", 26, 6666.66),
 *             new Employee("赵六", 26, 6666.66),
 *             new Employee("田七", 24, 5555.55)
 *     );
 *
 *  List<Employee> collect = employees.stream().filter(distinctByKey(Employee::getName)).collect(Collectors.toList());
 *  collect.forEach(employee -> System.out.println(employee));
 */
public class DistinctByKey {
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
