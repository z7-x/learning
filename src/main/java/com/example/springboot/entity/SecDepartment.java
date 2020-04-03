package com.example.springboot.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 项目名称：data-leading-in
 * 类 名 称：SecDepartment
 * 类 描 述：TODO
 * 创建时间：2020/3/31 4:22 下午
 * 创 建 人：apple
 */
@Entity
@Table(name = "sec_department")
@Data
public class SecDepartment {
    /**
     * 部门编号
     */
    @Id
    @Column(name = "DEPARTMENTID")
    private String sn;

    /**
     *
     */
    @Column(name = "DEPARTMENTNAME")
    private String deptName;

}
