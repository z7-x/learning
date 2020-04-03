package com.example.springboot.service.impl;

import com.example.springboot.entity.SecEmployee;
import com.example.springboot.repository.SecEmployeeRepositoty;
import com.example.springboot.service.SecEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：data-leading-in
 * 类 名 称：SecEmployeeImpl
 * 类 描 述：TODO
 * 创建时间：2020/4/1 5:25 下午
 * 创 建 人：apple
 */
@Service
public class SecEmployeeImpl  implements SecEmployeeService {

    @Autowired
    private SecEmployeeRepositoty secEmployeeRepositoty;
    @Override
    public List<SecEmployee> getEmployeeAll() {
        List<SecEmployee>  secEmployeeList = secEmployeeRepositoty.findAll();
        return secEmployeeList;
    }
}
