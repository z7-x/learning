package com.example.springboot.repository;

import com.example.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 项目名称：data-leading-in
 * 类 名 称：EmployeeRepositoty
 * 类 描 述：TODO
 * 创建时间：2020/4/1 5:31 下午
 * 创 建 人：apple
 */
@Repository
public interface EmployeeRepositoty extends JpaRepository<Employee, Long> {
    /**
     * 根据老系统sn字段转id主键
     */
    @Query(nativeQuery = true, value = "select oe.id from org_employee oe where oe.sn = :sn")
    int getSnQueryId(@Param("sn") String sn);

    /**
     * 根据userID查询主键ID
     */
    @Query(nativeQuery = true, value = "select oe.id  from org_employee oe  where oe.UserId= :userId")
    int findByName(@Param("userId") String userId);
}
