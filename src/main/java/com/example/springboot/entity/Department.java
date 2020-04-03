package com.example.springboot.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 项目名称：data-leading-in
 * 类 名 称：Department
 * 类 描 述：TODO
 * 创建时间：2020/3/31 3:49 下午
 * 创 建 人：apple
 */
@Entity
@Table(name = "org_department")
@Data
public class Department {
    /**
     * 部门编号
     */
    @Id
    @GeneratedValue//默认自增
    @Column(name = "id")
    private Long id;

    /**
     * 部门名称
     */
    @Column(name = "name")
    private  String name;

    /**
     *
     */
    @Column(name = "sn")
    private  String sn;

    /**
     * 组织编码
     */
    @Column(name = "organization_id")
    private  String organizationId;
}
