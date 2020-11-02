package com.example.reflect.clzzTest;

import com.example.reflect.pojo.Person;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/10/29 4:18 下午
 * @Author z7-x
 */
public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException {
        //案例：以Person 的字节码信息为案例
        //方式1
        Person person1 = new Person();
        Class<? extends Person> c1 = person1.getClass();
        System.out.println("方式一：" + c1);

        //方式2
        Class<Person> c2 = Person.class;
        System.out.println("方式二：" + c2);

        System.out.println(c1 == c2);

        //方式3:最常用的
        Class<?> c3 = Class.forName("com.example.reflect.pojo.Person");
        System.out.println("方式三：" + c3);

        //方式4：利用类加载器
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass("com.example.reflect.pojo.Person");
        System.out.println(aClass);

    }

    /**
     * Class类的具体实例：
     * 1> 类：外部类，内部类
     * 2> 接口
     * 3> 注解
     * 4> 数组
     * 5> 基本数据类型
     * 6> void
     */
    @org.junit.Test
    public void test1() {
        Class<Person> personClass = Person.class;
        Class<Comparable> comparableClass = Comparable.class;
        Class<Override> overrideClass = Override.class;

        int[] arr1 = {1,2,3,4};
        Class<? extends int[]> aClass = arr1.getClass();
        int[] arr2 = {5,6,7,8};
        Class<? extends int[]> aClass1 = arr2.getClass();
        System.out.println(aClass == aClass1);//结果：true  同一纬度，同一元素类型，得到的字节码就是同一个

        Class<Integer> integerClass = int.class;

        Class<Void> voidClass = void.class;

    }
}
