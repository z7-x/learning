package com.example.springboot.service;

import com.example.springboot.entity.ContactHead;
import com.example.springboot.entity.YsProject;

import java.util.List;

/**
 * 项目名称：springboot-excel
 * 类 名 称：ProjectService
 * 类 描 述：TODO
 * 创建时间：2020/3/16 10:59 上午
 * 创 建 人：apple
 */
public interface ProjectService {
    //批量插入
    int batchInsertProject(List<ContactHead> uidList) throws  Exception;
}
