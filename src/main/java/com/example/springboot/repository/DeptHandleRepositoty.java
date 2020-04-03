package com.example.springboot.repository;

import com.example.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目名称：data-leading-in
 * 类 名 称：DataHandleRepositoty
 * 类 描 述：TODO
 * 创建时间：2020/3/31 3:40 下午
 * 创 建 人：apple
 */
@Repository
public interface DeptHandleRepositoty extends JpaRepository<Department,Long> {
    List<Department> findAll();
}
