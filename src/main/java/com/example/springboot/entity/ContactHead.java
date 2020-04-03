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
@Table(name = "b_contacthead")
@Data
public class ContactHead {

    /**
     * 拆分主表ID
     */
    @Id
    @Column(name = "Uid")
    private String Uid;

}
