package com.example.reflect.service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @Classname MyAnnotation
 * @Description TODO
 * @Date 2020/10/30 11:13 上午
 * @Author z7-x
 */

/**
 *  @Target:定义当前的注解能够修饰程序中的哪些元素
 *  @Retention： 定义注解的生命周期
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value();//属性
}
