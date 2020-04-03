package com.example.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 项目名称：data-leading-in
 * 类 名 称：DataHandleControllerTest
 * 类 描 述：TODO
 * 创建时间：2020/4/1 10:41 上午
 * 创 建 人：apple
 */
public class DataHandleControllerTest {

    public static void main(String[] args) {
        List<String> A = new ArrayList<>();
        A.add("A");
        A.add("B");
        A.add("C");
        A.add("D");

        List<String>B = new ArrayList<>();
        B.add("C");
        B.add("D");
        B.add("E");
        B.add("F");
        List<String> C = new ArrayList<>();
        C.addAll(A);
        C.removeAll(B);
    }

}