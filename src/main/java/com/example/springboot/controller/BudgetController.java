package com.example.springboot.controller;

import com.example.springboot.entity.ContactHead;
import com.example.springboot.entity.Dbudgetcategory;
import com.example.springboot.service.BudgetService;
import com.example.springboot.service.DbudgetcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目名称：data-leading-in
 * 类 名 称：BudgetController
 * 类 描 述：TODO
 * 创建时间：2020/3/30 9:59 上午
 * 创 建 人：apple
 */

@RestController
public class BudgetController {

    @Autowired
    private BudgetService budgetService;
    @Autowired
    private DbudgetcategoryService dbudgetcategoryService;

    @RequestMapping("/importBudget")
    public void importBudget() throws Exception {
        List<Dbudgetcategory> bList =  dbudgetcategoryService.getList();
        if(bList!=null&&bList.size()>0){
           int count =  budgetService.addBudget(bList);
           if(count > 0){
               System.out.println("output ：budget data import success");
           }else{
               System.out.println("output ：budget data import defeated");
           }
        }
    }

}
