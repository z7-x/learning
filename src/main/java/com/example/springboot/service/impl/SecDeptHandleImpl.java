package com.example.springboot.service.impl;

import com.example.springboot.entity.SecDepartment;
import com.example.springboot.repository.SecDeptHandleRepositoty;
import com.example.springboot.service.SecDeptHandleService;
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
public class SecDeptHandleImpl implements SecDeptHandleService {

    @Autowired
    private SecDeptHandleRepositoty secDeptHandleRepositoty;

    @Override
    public List<SecDepartment> findAll() {
        return secDeptHandleRepositoty.findAll();
    }
}
