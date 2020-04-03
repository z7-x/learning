package com.example.springboot.repository;

import com.example.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 项目名称：data-leading-in
 * 类 名 称：EmployeeRepositoty
 * 类 描 述：TODO
 * 创建时间：2020/4/1 5:31 下午
 * 创 建 人：apple
 */
@Repository
public interface EmployeeRepositoty  extends JpaRepository<Employee,Long> {

}
