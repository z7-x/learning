package com.example.springboot.service.impl;

import com.example.springboot.entity.Department;
import com.example.springboot.repository.DeptHandleRepositoty;
import com.example.springboot.service.DeptHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：data-leading-in
 * 类 名 称：DataHandleImpl
 * 类 描 述：TODO
 * 创建时间：2020/3/31 3:39 下午
 * 创 建 人：apple
 */
@Service
public class DeptHandleImpl implements DeptHandleService {

    @Autowired
    private  DeptHandleRepositoty  deptHandleRepositoty;

    @Override
    public List<Department> findAll() throws  Exception{
        return deptHandleRepositoty.findAll();
    }

    @Override
    public int addDepartment(List<Department> newDept) throws Exception{
        int count = 0;
        deptHandleRepositoty.saveAll(newDept);
        count ++;
        return count;
    }
}
