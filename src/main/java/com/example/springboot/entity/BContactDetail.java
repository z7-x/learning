package com.example.springboot.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 项目名称：springboot-excel
 * 类 名 称：ContactHead
 * 类 描 述：TODO
 * 创建时间：2020/3/16 11:14 上午
 * 创 建 人：apple
 */
@Entity
@Table(name = "b_contactDetail")
@Data
public class BContactDetail {

    /**
     * 主表ID
     */
    @Id
    @Column(name = "UID")
    private String Uid;

    /**
     *  项目名称
     */
    @Column( name ="PURCHASECONTENT")
    private String purchaseContentName;

    /**
     * 总额
     */
    @Column(name =  "AMOUNT")
    private String amount;

    /**
     * 状态
     */
    @Column(name =  "IMPORTREPORTSTATUS")
    private String importReportStatus;

}
