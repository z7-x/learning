package com.example.springboot.service;

import com.example.springboot.entity.Dbudgetcategory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 项目名称：springboot-excel
 * 类 名 称：budgetService
 * 类 描 述：TODO
 * 创建时间：2020/3/10 3:47 下午
 * 创 建 人：apple
 */
public interface BudgetService {
    //excel导入预算信息
//    int addBudget(MultipartFile file) throws Exception;

    //导入预算信息
    int addBudget(List<Dbudgetcategory> bList) throws  Exception;
}
