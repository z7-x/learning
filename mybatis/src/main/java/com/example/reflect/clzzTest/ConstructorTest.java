package com.example.reflect.clzzTest;

import com.example.reflect.pojo.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @Classname Test2
 * @Description TODO
 * @Date 2020/10/30 11:30 上午
 * @Author z7-x
 */
public class ConstructorTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取字节码信息
        Class<Student> studentClass = Student.class;

        //通过字节码获取构造器
        Constructor<?>[] constructors = studentClass.getConstructors();
        Arrays.stream(constructors).
                forEach(constructor -> System.out.println(constructor));

        System.out.println("======================================================================");

        //获取指定构造器：默认 无参构造
        Constructor<Student> constructor = studentClass.getConstructor();
        System.out.println(constructor);

        //获取int double 两个参数
        Constructor<Student> constructor1 = studentClass.getConstructor(int.class, double.class);
        System.out.println(constructor1);

        //获取 私有的构造器 两个参数
        Constructor<Student> constructor2 = studentClass.getDeclaredConstructor(double.class, double.class);
        System.out.println(constructor2);

        System.out.println("======================================================================");

        Student student = constructor.newInstance();
        System.out.println(student);

        Student student1 = constructor1.newInstance(1, 12.03);
        System.out.println(student1);

        Student student2 = constructor2.newInstance(2, 2);
        System.out.println(student2);

    }
}
