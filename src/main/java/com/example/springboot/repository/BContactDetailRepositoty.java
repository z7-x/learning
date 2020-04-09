package com.example.springboot.repository;

import com.example.springboot.entity.BContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目名称：springboot-excel
 * 类 名 称：ContactHeadRepositoty
 * 类 描 述：TODO
 * 创建时间：2020/3/16 11:27 上午
 * 创 建 人：apple
 */
@Repository
public interface BContactDetailRepositoty extends JpaRepository<BContactDetail,Long> {
    @Query(nativeQuery = true,value = "select t.Uid from b_contactDetail t where 1=1")
    List<BContactDetail> findAll();
}
