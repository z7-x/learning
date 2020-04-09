package com.example.springboot.controller;

import com.example.springboot.entity.Department;
import com.example.springboot.entity.Employee;
import com.example.springboot.entity.SecDepartment;
import com.example.springboot.entity.SecEmployee;
import com.example.springboot.service.DeptHandleService;
import com.example.springboot.service.EmployeeService;
import com.example.springboot.service.SecDeptHandleService;
import com.example.springboot.service.SecEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目名称：data-leading-in
 * 类 名 称：DataHandleController
 * 类 描 述：TODO
 * 创建时间：2020/3/31 3:31 下午
 * 创 建 人：apple
 */
@RestController
public class DataHandleController {

    @Autowired
    private DeptHandleService deptHandleService;
    @Autowired
    private SecDeptHandleService secDeptHandleService;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private SecEmployeeService secEmployeeService;

    /**
     * 部门编号处理
     */
    @RequestMapping("/importDepartment")
    public void departmentHandle() throws Exception{
        List<Department> deptList = deptHandleService.findAll();
        List<SecDepartment> sdeptList = secDeptHandleService.findAll();
        DataHandler(deptList,sdeptList);
     }

    /**
     * 将老系统跟新系统的部门比较，将新系统中没有老系统中有的同步到新系统的部门表中
     * @param deptList  新系统部门集合
     * @param sdeptList 老系统部门集合
     * @throws Exception
     */
    public void DataHandler(List<Department> deptList,List<SecDepartment> sdeptList) throws Exception {
        List<Department> newDept = new ArrayList<>();
        //获取新部门的sn列表
        List<String> dsns = deptList.stream().map(Department::getSn).collect(Collectors.toList());
        //获得重复的部门
        List<SecDepartment> chongfu = sdeptList.stream().filter(item -> dsns.contains(item.getSn())).collect(Collectors.toList());
        //获得重复的sn列表
        List<String> cfsn = chongfu.stream().map(SecDepartment::getSn).collect(Collectors.toList());
        //获取不重复的部门
        List<SecDepartment> buchongfu = sdeptList.stream().filter(item -> !cfsn.contains(item.getSn())).collect(Collectors.toList());
        for(SecDepartment secDepartment: buchongfu){
            Department department = new Department();
            department.setSn(secDepartment.getSn());
            department.setName(secDepartment.getDeptName());
            department.setOrganizationId("skys");
            newDept.add(department);
        }
        int count =  deptHandleService.addDepartment(newDept);
        if(count>0){
            System.out.println("老系统部门同步成功！");
        }else{
            System.out.println("老系统部门同步失败！");
        }
    }


    /**
     * 员工编号处理
     * 1、数据库新增列: alter table org_employee add UserId varchar(255)
     */
    @RequestMapping("/importEmployee")
    public void empNoHandle() throws Exception {
        //老系统数据人员信息
        List<SecEmployee> secEmployeesList = secEmployeeService.getEmployeeAll();
        //新系统人员数据
        List<Employee> employeeList = employeeService.getAllEmployee();
        if(secEmployeesList.size()>0){
          int count =  employeeService.addEmployee(secEmployeesList,employeeList);
          if(count>0){
              System.out.println("老系统员工同步成功！");
          }else{
              System.out.println("老系统员工同步失败！");
          }
        }
    }
}
