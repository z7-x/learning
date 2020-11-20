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

    /**
     * 添加用户
     */
    void insertMUser(MUser mUser);

    /**
     * 删除用户
     */
    Integer deleteUser(String id);

    /**
     * 修改用户
     */
    void updateUser(MUser mUser);
}
