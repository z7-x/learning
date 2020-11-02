package com.example.reflect.pojo;

import lombok.Data;

/**
 * @Classname Person
 * @Description TODO
 * @Date 2020/10/28 11:25 上午
 * @Author z7-x
 */
@Data
public class Person {
    private int age;
    public String name;

    private void eat() {
        System.out.println("Person--------eat");
    }

    public void sleep() {
        System.out.println("Person-------sleep");
    }
}
