package com.example.springboot.service.impl;

import static org.junit.Assert.*;

/**
 * 项目名称：data-leading-in
 * 类 名 称：BudgetServiceImplTest
 * 类 描 述：TODO
 * 创建时间：2020/3/31 10:51 上午
 * 创 建 人：apple
 */
public class BudgetServiceImplTest {

    public static void main(String[] args) {
        String number = "13573992.92";
        if(number.contains(".")){
            System.out.println(number.split("\\.")[0]);
        }else{
            System.out.println(111);
        }

    }
}