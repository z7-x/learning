package com.example.springboot.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 项目名称：springboot-excel
 * 类 名 称：AutomaticCreateTable
 * 类 描 述：TODO
 * 创建时间：2020/3/17 4:04 下午
 * 创 建 人：apple
 */
@Data
@Entity
@Table(name = "AutomaticCreateTable")
public class AutomaticCreateTable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "userName",length = 20)
    private String userNmae;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "tel",length = 20)
    private String tel;
}
