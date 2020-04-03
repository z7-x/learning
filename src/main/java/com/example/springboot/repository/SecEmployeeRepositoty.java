package com.example.springboot.repository;

import com.example.springboot.entity.SecEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目名称：data-leading-in
 * 类 名 称：SecEmployeeRepositoty
 * 类 描 述：TODO
 * 创建时间：2020/4/1 5:22 下午
 * 创 建 人：apple
 */
@Repository
public interface SecEmployeeRepositoty  extends JpaRepository<SecEmployee,String> {
    @Query(nativeQuery = true,value = "select t.userId,t.userName,t.employeeno,t.sex from sec_user t where 1=1")
    List<SecEmployee> findAll();
}
