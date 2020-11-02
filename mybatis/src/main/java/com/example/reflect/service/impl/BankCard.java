package com.example.reflect.service.impl;

import com.example.reflect.service.TakeOut;

/**
 * @Classname BankCard
 * @Description TODO
 * @Date 2020/10/22 4:26 下午
 * @Author z7-x
 */
public class BankCard  implements TakeOut {
    @Override
    public void payOnline() {
        //具体的银行卡支付
        System.out.println("正在使用招商银行进行支付...");
    }
}
