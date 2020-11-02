package com.example.reflect.pojo;

import com.example.reflect.service.MyAnnotation;
import com.example.reflect.service.MyInterface;
import lombok.Data;

/**
 * @Classname Student
 * @Description TODO
 * @Date 2020/10/28 11:28 上午
 * @Author z7-x
 */
@Data
@MyAnnotation("hello Student")
public class Student extends Person implements MyInterface {
    private int sNo;
    public double height;
    private double weight;
    protected double score;

    @Override
    @MyAnnotation("hello  myMethod")
    public void myMethod() throws RuntimeException {
        System.out.println("我重写了myMethod方法");
    }

    public void happy() {
        System.out.println("做人最开心的就是开心每一天");
    }

    protected int getsNo() {
        return sNo;
    }

    @MyAnnotation("hello showInfo")
    public String showInfo() {
        return "我是一名三好学生";
    }

    public String showInfo(int a, int b) {
        return "我真的是一名三好学生我是一名三好学生我是一名三好学生" ;
    }

    private void work() {
        System.out.println("我以后工作会成为一名程序员");
    }

    public Student() {
        System.out.println("空参构造器");
    }

    public Student(int sNo) {
        this.sNo = sNo;
    }

    public Student(int sNo, double weight) {
        this.sNo = sNo;
        this.weight = weight;
    }

    public Student(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    protected Student(int sno, double height, double weight) {
        this.sNo = sno;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sNo=" + sNo +
                ", height=" + height +
                ", weight=" + weight +
                ", score=" + score +
                '}';
    }
}
