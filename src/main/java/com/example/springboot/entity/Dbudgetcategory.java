package com.example.springboot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 项目名称：data-leading-in
 * 类 名 称：DBudgetcategory
 * 类 描 述：TODO
 * 创建时间：2020/3/30 10:38 上午
 * 创 建 人：apple
 */
@Entity
@Table(name = "d_budgetcategory")
@Data
public class Dbudgetcategory implements Serializable {

    @Id
    @Column(name = "BUDGETNO")
    private String budgetNo;

    @Column(name = "BUDGETYEARNUM", length = 255)
    private String budgetYearNum;

    @Column(name = "BUDGETCOMPANY", length = 255)
    private String budgetCompany;

    @Column(name = "BUDGETPROJECTNAME", length = 255)
    private String budgetProjectName;

    @Column(name = "BUDGETAMOUNT", length = 255)
    private String budgetAmount;

    @Column(name = "SPLITAMOUNT", length = 255)
    private String bplitAmount;

    @Column(name = "UNSPLITAMOUNT", length = 255)
    private String unSplitAmount;

    @Column(name = "BUDGETCATEGORY", length = 255)
    private String budgetCategory;

    @Column(name = "BUDGETREMARK", length = 255)
    private String budgetRemark;

    @Column(name = "RELATEDDEPARTMENTID", length = 255)
    private String relatedDepartmentId;

    @Column(name = "RELATEDDEPARTMENTNAME", length = 255)
    private String relatedDepartmentName;

    @Column(name = "SEED", length = 255)
    private String seed;

    @Column(name = "CANBESPLIT", length = 255)
    private String canbeSplit;

    @Column(name = "ISLOCK", length = 255)
    private String isLock;

    @Column(name = "INSTANCEID", length = 255)
    private String instanceId;

    @Column(name = "STATISTICALTYPE", length = 255)
    private String statisticalType;
}
