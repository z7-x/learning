package com.example.springboot.service;

import com.example.springboot.entity.Department;
import com.example.springboot.entity.SecDepartment;

import java.util.List;

/**
 * 项目名称：data-leading-in
 * 类 名 称：DataHandleService
 * 类 描 述：TODO
 * 创建时间：2020/3/31 3:39 下午
 * 创 建 人：apple
 */
public interface SecDeptHandleService {
    List<SecDepartment> findAll();
}
