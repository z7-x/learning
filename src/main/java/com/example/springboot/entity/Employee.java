package com.example.springboot.entity;


import lombok.Data;

import javax.persistence.*;

/**
 * 项目名称：data-leading-in
 * 类 名 称：Employee
 * 类 描 述：TODO
 * 创建时间：2020/4/1 3:50 下午
 * 创 建 人：apple
 */
@Entity
@Table(name = "org_employee")
@Data
public class Employee {
    /**
     * 员工编号
     */
    @Id
    @GeneratedValue//默认自增
    @Column(name = "id")
    private Long id;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 性别
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 标识码
     */
    @Column(name = "sn")
    private String sn;

    /**
     * 老系统UserId主键
     */
    @Column(name ="userid")
    private String userId;

}
