package com.example.springboot.entity;



import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 项目名称：springboot-excel
 * 类 名 称：YsBudget
 * 类 描 述：TODO
 * 创建时间：2020/3/10 3:53 下午
 * 创 建 人：apple
 */
@Entity
@Table(name = "ys_budget")
@Data
public class YsBudget {

    /**
     * 预算ID
     */
    @Id
    @GeneratedValue//默认自增
    @Column(name = "id")
    private Long id;

    /**
     * 预算编号
     */
    @Column(name = "SN", length = 200)
    private String sn;
    /**
     * 预算名称
     */
    @Column(name = "NAME", length = 50)
    private String name;
    /**
     * 预算年度
     */
    @Column(name = "YEAR", length = 50)
    private String year;
    /**
     * 类别开0办费/其他1设备2一般设备3大型设备4大修5信息化项目
     */
    @Column(name = "TYPE", length = 50)
    private String type;
    /**
     * 医院
     */
    @Column(name = "HOSPITAL", length = 50)
    private String hospital;
    /**
     * 预算金额
     */
    @Column(name = "BUDGET_MONEY", length = 50)
    private Integer budgetMoney;
    /**
     * 已申请金额
     */
    @Column(name = "APPLIED_MONEY", length = 50)
    private Integer appliedMoney;
    /**
     * 预算余额
     */
    @Column(name = "BUDGET_BALANCE", length = 50)
    private Integer budgetBalance;
    /**
     * 开始时间
     */
    @Column(name = "START_TIME", length = 50)
    private Date startTime;
    /**
     * 结束时间
     */
    @Column(name = "END_TIME", length = 50)
    private Date endTime;
    /**
     * 备注
     */
    @Column(name = "REMARKS", length = 50)
    private String remarks;

    /**
     * 状态0,执行中1完成,2滞后
     */
    @Column(name = "STATUS", length = 10)

    private String status = "0";
    /**
     * 进度
     */
    @Column(name = "PROGRESS", length = 10)
    private String progress;


    /**
     * 部门编号
     */
    @Column(name = "department_id")
    private Long department_id;


}
