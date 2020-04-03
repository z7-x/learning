package com.example.springboot.repository;

import com.example.springboot.entity.ContactHead;
import com.example.springboot.entity.Dbudgetcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目名称：data-leading-in
 * 类 名 称：DbudgetRepositoty
 * 类 描 述：TODO
 * 创建时间：2020/3/30 11:43 上午
 * 创 建 人：apple
 */
@Repository
public interface DbudgetRepositoty extends JpaRepository<Dbudgetcategory, String> {
    @Query(nativeQuery = true,value = "select * from d_budgetcategory")
    List<Dbudgetcategory> findAll();
}
