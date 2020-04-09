package com.example.springboot.service.impl;

import com.example.springboot.entity.Employee;
import com.example.springboot.entity.SecEmployee;
import com.example.springboot.repository.EmployeeRepositoty;
import com.example.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目名称：data-leading-in
 * 类 名 称：EmployeeImpl
 * 类 描 述：TODO
 * 创建时间：2020/4/1 6:31 下午
 * 创 建 人：apple
 */
@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeRepositoty employeeRepositoty;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeRepositoty.findAll();
        return employeeList;
    }

    /**
     * @param secEmployeesList 老系统员工集合
     * @param employeeLists    新系统员工集合
     * @return 成功返回大于0的数值
     * @throws Exception
     */
    @Override
    public int addEmployee(List<SecEmployee> secEmployeesList, List<Employee> employeeLists) throws Exception {
        int count = 0;
//        List<Employee> employeeListDel = new ArrayList<>();
        List<Employee> employeeListIns = new ArrayList<>();
//        //新员工sn集合列表
//        List<String> newEmpSnList = employeeLists.stream().map(Employee::getSn).collect(Collectors.toList());
//        //重复的sn集合列表
//        List<SecEmployee> repetitionEmpSnList = secEmployeesList.stream().filter(item -> newEmpSnList.contains(item.getSn())).collect(Collectors.toList());
//        if (repetitionEmpSnList.size() > 0) {
//            for (SecEmployee repetitionEmp : repetitionEmpSnList) {
//                if (!repetitionEmp.getSn().equals("null")) {
//                    if (!repetitionEmp.getUserId().equals("null")) {
//                        Employee employee = new Employee();
//                        int ids = employeeRepositoty.findByName(repetitionEmp.getUserId());
//                        long id = (int) ids;
//                        employee.setId(id);
//                        employeeListDel.add(employee);
//                    }
//                }
//            }
//            employeeRepositoty.deleteInBatch(employeeListDel);
//        }


        for (SecEmployee secEmployee : secEmployeesList) {
            Employee employee = new Employee();
            employee.setName(secEmployee.getUserName());
            employee.setSn(secEmployee.getSn());
            employee.setUserId(secEmployee.getUserId());
            String sex = secEmployee.getSex();
            if ("男".equals(sex)) {
                employee.setSex("male");
            } else if ("女".equals(sex)) {
                employee.setSex("female");
            } else if (sex == null || sex.equals("")) {
                employee.setSex("male");
            }
            employeeListIns.add(employee);
        }

        employeeRepositoty.saveAll(employeeListIns);
        count++;
        return count;
    }

    @Override
    public int getSnQuertyId(String sn) {
        int id = employeeRepositoty.getSnQueryId(sn);
        return id;
    }
}
