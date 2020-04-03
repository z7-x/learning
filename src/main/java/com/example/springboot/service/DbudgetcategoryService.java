package com.example.springboot.service;

import com.example.springboot.entity.ContactHead;
import com.example.springboot.entity.Dbudgetcategory;

import java.util.List;

/**
 * 项目名称：data-leading-in
 * 类 名 称：Dbudgetcategory
 * 类 描 述：TODO
 * 创建时间：2020/3/30 11:57 上午
 * 创 建 人：apple
 */
public interface DbudgetcategoryService {
    List<Dbudgetcategory> getList() throws  Exception;
}
