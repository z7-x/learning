package learning.features.optional.test;

import learning.features.lambda.bean.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * @Classname TestOptional
 * @Description TODO
 * @Date 2020/8/25 3:29 下午
 * @Author z7-x
 */
public class TestOptional {

    /**
     * Optional.of(T t);                创建一个 Optional实例
     * Optional.empty();                创建一个空的Optional实例
     * Optional.ofNullable(T t);        若t不为null返回Optional实例，否则创建空Optional实例
     */
    @Test
    public void test1() {
        Optional<Employee> o = Optional.of(new Employee());
        System.out.println(o.get());

        Optional<Employee> empty = Optional.empty();
        System.out.println(empty.get());

        Optional<Employee> o1 = Optional.ofNullable(new Employee());
        System.out.println(o1.get());
    }

    /**
     * isPresent();                     判断是否包含值
     * orElse(T t);                     如果调用对象包含值，返回该值，否则返回t
     * orElseGet(Supplier s);           如果调用对象包含值，返回该值，否则返回s获取的值
     */
    @Test
    public void test2() {
        Optional<Employee> employee = Optional.ofNullable(null);
        if (employee.isPresent()) {
            System.out.println(employee.get());
        }

        Employee employee1 = employee.orElse(new Employee("张三", 12, 999.00));
        System.out.println(employee1);

        Employee employee2 = employee.orElseGet(() -> new Employee());
        System.out.println(employee2);
    }

    /**
     * map      如果有值对其进行处理，并返回处理后的Optional,否则返回Optional.empty();
     * flatMap  与map类似，要求值必须返回Optional
     */
    @Test
    public void test3() {
        Optional<Employee> optional = Optional.ofNullable(new Employee("张三", 12, 777.00));
        Optional<String> name = optional.map((param) -> param.getName());//或者Employee::getName
        System.out.println(name.get());

        Optional<Employee> employee =
                Optional.ofNullable(new Employee())
                        .flatMap(param -> Optional.ofNullable(new Employee("李四", 12, 29.00)));
        System.out.println(employee.get());
    }
}
