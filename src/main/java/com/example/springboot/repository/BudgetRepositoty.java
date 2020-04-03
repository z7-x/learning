package com.example.springboot.repository;

import com.example.springboot.entity.YsBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 操作接口
 */
@Repository
public interface BudgetRepositoty extends JpaRepository<YsBudget, Long> {

}