package com.example.springboot.service.impl;


import com.example.springboot.entity.Dbudgetcategory;
import com.example.springboot.entity.YsBudget;
import com.example.springboot.repository.BudgetRepositoty;
import com.example.springboot.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：springboot-excel
 * 类 名 称：BudgetServiceImpl
 * 类 描 述：TODO
 * 创建时间：2020/3/10 3:48 下午
 * 创 建 人：apple
 */

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private BudgetRepositoty budgetRepositoty;

    @Override
    public int addBudget(List<Dbudgetcategory> bList) throws Exception {
        int count = 0;
        List<YsBudget> budgetList = new ArrayList<>();
        for(Dbudgetcategory budgets:bList){
            YsBudget budget = new YsBudget();

            /**
             * 已申请金额
             */
            String budgetAmount = budgets.getBudgetAmount();
            if(budgetAmount.contains(".")){
                budgetAmount = budgets.getBudgetAmount().split("\\.")[0];
            }
            budget.setAppliedMoney(Integer.valueOf(budgetAmount));

            /**
             * 预算余额
             */
            String bplitAmount = budgets.getBplitAmount();
            if(bplitAmount.contains(".")){
                bplitAmount = budgets.getBplitAmount().split("\\.")[0];
            }
            budget.setBudgetBalance(Integer.valueOf(bplitAmount));

            /**
             * 预算金额
             */
            String unSplitAmount = budgets.getUnSplitAmount();
            if(unSplitAmount.contains(".")){
                unSplitAmount = budgets.getUnSplitAmount().split("\\.")[0];
            }
            budget.setBudgetMoney(Integer.valueOf(unSplitAmount));

            /**
             * 医院编号
             */
            budget.setHospital(budgets.getRelatedDepartmentId());

            /**
             * 预算名称
             */
            budget.setName(budgets.getBudgetProjectName());

            /**
             * 预算编号
             */
            budget.setSn(budgets.getBudgetNo());

            /**
             * 预算类型
             */
            String type = budgets.getStatisticalType();
            switch (type){
                case "信息": budget.setType("2");
                break;
                case "大型设备":budget.setType("4");
                break;
                case "小型设备":budget.setType("5");
                break;
                case "设备":budget.setType("6");
                break;
                case "大修":budget.setType("3");
                break;
                case "其他":budget.setType("7");
                break;
                default:budget.setType("7");
            }

            /**
             * 预算年份
             */
            budget.setYear(budgets.getBudgetYearNum());

            /**
             * 部门编号
             */
            budget.setDepartment_id(new Long(0));

            budgetList.add(budget);
        }

        if(budgetList!=null&&budgetList.size()>0){
            budgetRepositoty.saveAll(budgetList);
            count ++;
            }
        return count;
    }
//            /**
//             * 数据行插入
//             * 判断数据库表中是否存在用户记录，若存在，则更新，不存在，则保存记录
//             */
////            for(YsBudget budgets:budgetList){
//////              YsBudget budget = budgetRepositoty.findById(budgets.getId()).orElse(null);
////                YsBudget budget  = budgetRepositoty.findOne(Example.of(budgets)).orElse(null);
////                if(budget == null){
////                    budgetRepositoty.save(budgets);
////                }else{
////                    budgetRepositoty.saveAndFlush(budgets);
////                }
////            }
//
//            /**
//             * 批量插入
//             */
//            if(budgetList!=null&&budgetList.size()>0){
//                budgetRepositoty.saveAll(budgetList);
//            }
//        }
//    }

}
