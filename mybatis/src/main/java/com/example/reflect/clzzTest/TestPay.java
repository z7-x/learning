package com.example.reflect.clzzTest;

import com.example.reflect.service.TakeOut;
import com.example.reflect.service.impl.AliPay;
import com.example.reflect.service.impl.BankCard;
import com.example.reflect.service.impl.WeChat;

/**
 * @Classname TestPay
 * @Description TODO
 * @Date 2020/10/16 2:07 下午
 * @Author z7-x
 */

/**
 * 原始解决：
 */
public class TestPay {
    public static void main(String[] args) {
        String str = "招商银行";
        if("微信".equals(str)){
            //微信支付
            pay(new WeChat());
        }

        if("支付宝".equals(str)){
            //支付宝支付
           pay(new AliPay());
        }

        if("招商银行".equals(str)){
            //银行卡支付
            pay(new BankCard());
        }

    }
//
//    public static void  pay(WeChat weChat){
//        weChat.payOnline();
//    }
//
//    public static void  pay(AliPay aliPay){
//        aliPay.payOnline();
//    }
//
//    public static void  pay(BankCard bankCard){
//        bankCard.payOnline();
//    }

    //方法形参是接口，具体传入的是接口的实现类的对象---> 多态的一种形式

    /**
     * 多态确实可以提高代码的扩展性，但是：扩展性没有达到最好
     * 怎么没有达到最好：上面的分支，还是需要手动删除或者添加
     * 解决方法：引入反射机制
     * @param takeOut
     */
    public static  void pay(TakeOut takeOut){
        takeOut.payOnline();
    }
}