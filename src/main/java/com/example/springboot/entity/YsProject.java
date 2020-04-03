package com.example.springboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 项目名称：springboot-excel
 * 类 名 称：YsProject
 * 类 描 述：TODO
 * 创建时间：2020/3/16 10:38 上午
 * 创 建 人：apple
 */
@Entity
@Table(name = "ys_project")
@Data
public class YsProject {

    /**
     * 项目ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 25)
    private Long id;

    /**
     * 拆分主表ID
     */
    @Column(name = "bcontactheaduid",length = 100)
    private String bcontactheadUID;
}
