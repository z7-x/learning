package com.example.reflect.service.impl;

import com.example.reflect.service.TakeOut;

/**
 * @Classname Alipay
 * @Description TODO
 * @Date 2020/10/16 2:05 下午
 * @Author z7-x
 */
public class AliPay implements TakeOut {
    @Override
    public void payOnline() {
        //具体的支付宝支付
        System.out.println("正在使用支付宝进行支付...");
    }
}
