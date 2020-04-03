package com.example.springboot.utill;

/**
 * 项目名称：springboot-excel
 * 类 名 称：MyException
 * 类 描 述：TODO
 * 创建时间：2020/3/10 4:12 下午
 * 创 建 人：apple
 */
public class MyException  extends RuntimeException {

    private static final long serialVersionId = 1L;

    public MyException(String message) {
        super(message);
    }
}
