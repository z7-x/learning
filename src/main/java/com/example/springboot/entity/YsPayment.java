package com.example.springboot.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 项目名称：data-leading-in
 * 类 名 称：YsPayment
 * 类 描 述：TODO
 * 创建时间：2020/4/3 9:58 上午
 * 创 建 人：apple
 */
@Entity
@Data
@Table(name = "ys_parment")
public class YsPayment {

    @Id
    @Column(name =  "ID")
    @GeneratedValue
    private Long id;

    @Column(name =  "FK_MONEY")
    private int fkMoney;

    @Column(name = "STEP_NAME")
    private String stepName;

    @Column(name = "INS_ID")
    private String insId;
}
