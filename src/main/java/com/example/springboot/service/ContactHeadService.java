package com.example.springboot.service;

import com.example.springboot.entity.ContactHead;
import com.example.springboot.entity.YsProject;

import java.util.List;

/**
 * 项目名称：springboot-excel
 * 类 名 称：ContactHeadService
 * 类 描 述：TODO
 * 创建时间：2020/3/16 11:29 上午
 * 创 建 人：apple
 */
public interface ContactHeadService {
    //读取b_contacthead表的主键集合
    List<ContactHead>  getUidList() throws  Exception;
}
