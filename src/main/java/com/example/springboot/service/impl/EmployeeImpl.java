package com.example.springboot.service.impl;

import com.example.springboot.entity.Employee;
import com.example.springboot.entity.SecEmployee;
import com.example.springboot.repository.EmployeeRepositoty;
import com.example.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public int addEmployee(List<SecEmployee> secEmployeesList) {
        int count = 0 ;
        List<Employee> employeeList  = new ArrayList<>();
        for(SecEmployee secEmployee:secEmployeesList){
            Employee employee = new Employee();
            employee.setName(secEmployee.getUserName());
            if(secEmployee.getSn()==null){
                employee.setSn("sk001");
            }else{
                employee.setSn(secEmployee.getSn());
            }
            employee.setUserId(secEmployee.getUserId());
            if(secEmployee.getSex()!=null) {
                if(secEmployee.getSex().equals("男")){
                    employee.setSex("male");
                }else{
                    employee.setSex("female");
                }
                employeeList.add(employee);
            }
        }

        employeeRepositoty.saveAll(employeeList);
        count ++;
        return count;
    }
}
