package com.example.springboot.service.impl;

import com.example.springboot.entity.Dbudgetcategory;
import com.example.springboot.repository.DbudgetRepositoty;
import com.example.springboot.service.DbudgetcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：data-leading-in
 * 类 名 称：DbudgetcategoryImpl
 * 类 描 述：TODO
 * 创建时间：2020/3/30 11:59 上午
 * 创 建 人：apple
 */
@Service
public class DbudgetcategoryImpl implements DbudgetcategoryService {

    @Autowired
    private DbudgetRepositoty dbudgetRepositoty;

    @Override
    public List<Dbudgetcategory> getList() throws Exception {
        List<Dbudgetcategory> dList = dbudgetRepositoty.findAll();
        return dList;
    }
}
