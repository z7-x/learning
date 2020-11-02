package com.example.reflect.service.impl;

import com.example.reflect.service.TakeOut;

/**
 * @Classname WeChat
 * @Description TODO
 * @Date 2020/10/16 2:03 下午
 * @Author z7-x
 */
public class WeChat implements TakeOut {
    @Override
    public void payOnline() {
        //具体实现微信支付的功能
        System.out.println("正在使用微信功能支付...");
    }
}
