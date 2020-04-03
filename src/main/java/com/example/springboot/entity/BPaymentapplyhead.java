package com.example.springboot.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 项目名称：data-leading-in
 * 类 名 称：BPaymentapplyhead
 * 类 描 述：TODO
 * 创建时间：2020/4/3 11:12 上午
 * 创 建 人：apple
 */
@Entity
@Data
@Table(name =  "b_paymentapplyhead")
public class BPaymentapplyhead {

    @Id
    @GeneratedValue
    @Column(name = "UID")
    private String uid;

    @Column(name = "APPLICANTNO")
    private String applicantNo;

    @Column(name = "STATE")
    private String state;

    @Column(name = "PAYMENTAMOUNT")
    private String paymentAmount;
}
