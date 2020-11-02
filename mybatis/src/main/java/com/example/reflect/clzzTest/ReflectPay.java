package com.example.reflect.clzzTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Classname ReflectPay
 * @Description TODO
 * @Date 2020/10/23 9:32 上午
 * @Author z7-x
 */
public class ReflectPay {
    /**
     * java反射机制是在运行状态中，对于任意一个类，都知道这个类的所有属性和方法
     * 对于任意一个对象，都能够调用它的任意方法和属性，这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //定义一个字符串，用来模拟前台的支付方式
        String str = "com.example.reflect.service.impl.WeChat";

        //下面的代码就是利用反射机制
        Class cls = Class.forName(str);
        Object o = cls.newInstance();
        Method method = cls.getMethod("payOnline");
        method.invoke(o);

//        Method[] methods = cls.getMethods();
//        List<Method> collect = Arrays.stream(methods).collect(Collectors.toList());
//        for (Method method : collect) {
//            System.out.println(method);
//        }
    }

}
