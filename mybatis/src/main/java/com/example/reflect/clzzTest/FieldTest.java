package com.example.reflect.clzzTest;

import com.example.reflect.pojo.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @Classname FieldTest
 * @Description TODO
 * @Date 2020/10/30 3:38 下午
 * @Author z7-x
 */
public class FieldTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Student> student = Student.class;

        //getFields:获取运行时父类中被public修饰的属性
        Field[] field = student.getFields();
        Arrays.stream(field).forEach(item -> System.out.println(item));

        //getDeclaredFields：获取运行时类中的所有属性
        Field[] fields = student.getDeclaredFields();
        Arrays.stream(fields).forEach(field1 -> System.out.println(field1));

        //获取指定的公有属性
        Field field1 = student.getField("height");
        System.out.println(field1);

        //获取指定的私有属性
        Field field2 = student.getDeclaredField("sNo");
        System.out.println(field2);

        //获取属性名
        String name = field1.getName();
        System.out.println(name);

        //获取属性的数据类型
        Class<?> type = field1.getType();
        System.out.println(type);

        //获取属性的修饰符
        int modifiers = field1.getModifiers();
        System.out.println(modifiers);
        System.out.println(Modifier.toString(modifiers));

        //给属性赋值,必须要有对象
        Field height = student.getField("height");
        Object object = student.newInstance();
        height.setAccessible(true);//修改私有属性
        height.set(object, 1.78);//给object这个对象的height属性设置具体的值
        System.out.println(object);
    }
}
