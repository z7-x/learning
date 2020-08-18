package learning.jpa.lambda.test;

import learning.jpa.lambda.bean.Employee;
import learning.jpa.lambda.service.EmployeeByAgeFilter;
import learning.jpa.lambda.service.impl.MyPredicate;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname TestLambda
 * @Description TODO
 * @Date 2020/8/14 5:10 下午
 * @Author z7-x
 */
public class TestLambda1 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 22, 9999.99),
            new Employee("李四", 23, 2222.22),
            new Employee("王五", 22, 7777.77),
            new Employee("赵六", 26, 6666.66),
            new Employee("田七", 24, 5555.55)
    );

    public List<Employee> filterEmployeeAge(List<Employee> list) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() > 22) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Test
    public void test1() {
        List<Employee> employeeList = filterEmployeeAge(employees);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    // 优化方式一:策略设计模式  抽出一个公共接口，将具体的行为写一个类，实现公共接口即可
    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> filter) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employees) {
            if (filter.test(employee)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Test
    public void test2() {
        List<Employee> employees = filterEmployee(this.employees, new EmployeeByAgeFilter());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    //优化方式二:匿名内部类
    @Test
    public void test3() {
        List<Employee> employees = filterEmployee(this.employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() > 20;
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    //优化方式三: Lambda表达式
    @Test
    public void test4() {
        List<Employee> employees = filterEmployee(this.employees, (employee) -> employee.getSalary() >= 500);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    //优化方式四:StreamAPI
    @Test
    public void test5() {
        List<Employee> collect = employees.stream()
                .filter(employee -> employee.getSalary() > 5000)
                .limit(2)
                .collect(Collectors.toList());

        for (Employee employee : collect) {
            System.out.println("11" + employee);
        }

        List<String> goodsNameList = employees.stream().map(Employee::getName).collect(Collectors.toList());
        for (String employee : goodsNameList) {
            System.out.println("22" + employee);
        }
    }

    @Test
    public void test6() {
        //排序 默认升序 |  reversed：降序
        List<Employee> collect = employees.stream().sorted(Comparator.comparing(Employee::getAge))
                .collect(Collectors.toList());

        for (Employee employee : collect) {
            System.out.println("升序" + employee);
        }
    }

    @Test
    public void test7() {
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

}
