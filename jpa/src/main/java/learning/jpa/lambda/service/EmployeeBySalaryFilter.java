package learning.jpa.lambda.service;

import learning.jpa.lambda.bean.Employee;
import learning.jpa.lambda.service.impl.MyPredicate;

/**
 * @Classname EmployeeFilter
 * @Description TODO
 * @Date 2020/8/14 6:18 下午
 * @Author z7-x
 */
public class EmployeeBySalaryFilter implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        if (employee.getSalary() >= 5000) {
            return true;
        }
        return false;
    }
}
