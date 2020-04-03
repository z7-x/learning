package com.example.springboot.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 项目名称：data-leading-in
 * 类 名 称：SecEmployee
 * 类 描 述：TODO
 * 创建时间：2020/4/1 4:45 下午
 * 创 建 人：apple
 */
@Entity
@Table(name = "sec_user")
@Data
public class SecEmployee {
    /**
     * 员工编号
     */
    @Id
    @GeneratedValue//默认自增
    @Column(name = "USERID")
    private String userId;

    /**
     * 员工名称
     */
    @Column(name = "USERNAME")
    private String userName;

    /**
     * 标识码
     */
    @Column(name = "EMPLOYEENO")
    private String sn;

    /**
     * 性别
     */
    @Column(name = "SEX")
    private String sex;

}
