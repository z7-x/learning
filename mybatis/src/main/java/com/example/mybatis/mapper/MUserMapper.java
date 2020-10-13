package com.example.mybatis.mapper;

import com.example.mybatis.entity.MUser;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Classname MUserDao
 * @Description TODO
 * @Date 2020/10/12 3:25 下午
 * @Author z7-x
 */
@Mapper
public interface MUserMapper /**extends tk.mybatis.mapper.common.Mapper<MUser> **/{

    /**
     * 查询所有用户
     * @return
     */
    List<MUser> findByMUsers();
}
