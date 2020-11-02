package com.example.reflect.clzzTest;

import com.example.reflect.pojo.Student;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @Classname InvokingTest
 * @Description TODO
 * @Date 2020/10/30 5:26 下午
 * @Author z7-x
 */
public class InvokingTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //获取字节码信息
        Class<Student> cls = Student.class;

        //获取方法
        Method[] methods = cls.getMethods();
        Arrays.stream(methods).forEach(method -> System.out.println("公有方法：" + method));

        Method[] declaredMethods = cls.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(method -> System.out.println("所有方法：" + method));

        Method showInfo = cls.getMethod("showInfo", int.class, int.class);
        Method method = cls.getMethod("showInfo");
        System.out.println("两个参数" + showInfo);
        System.out.println("一个参数" + method);
        Student student = cls.newInstance();

        Object invoke = showInfo.invoke(student, 1, 2);
        System.out.println(invoke);


        //获取方法的具体结构
        /**
         * 修饰符 返回值类型 方法名（参数列表） throws Exception{}
         */
        System.out.println("方法名：" + showInfo.getName());
        System.out.println("修饰符：" + Modifier.toString(showInfo.getModifiers()));
        System.out.println("返回值：" + showInfo.getReturnType());
        //参数列表
        Class<?>[] parameterTypes = showInfo.getParameterTypes();
        Arrays.stream(parameterTypes).forEach(aClass ->
                System.out.println(aClass));

        //获取注解
        Annotation[] annotations = cls.getAnnotations();
        Arrays.stream(annotations).forEach(
                annotation -> System.out.println(annotation)
        );

        //获取异常
        Method myMethod = cls.getMethod("myMethod");
        Class<?>[] exceptionTypes = myMethod.getExceptionTypes();
        Arrays.stream(exceptionTypes).forEach(aClass -> System.out.println(aClass));

        //调用方法
        Object object = cls.newInstance();
//        myMethod.invoke(student);

        method.invoke(object);
    }

    @org.junit.Test
    public void test01() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class cls = Student.class;

        Method method1 = cls.getMethod("showInfo");
        Method method2 = cls.getMethod("showInfo", int.class, int.class);

        System.out.println(method1.getName());
        System.out.println(method2.getName());

        Object obj = cls.newInstance();
        method1.invoke(obj);


        System.out.println(method1.invoke(obj));
        System.out.println( method2.invoke(obj, 1, 1));


    }

}
