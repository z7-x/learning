package com.example.mybatis.service;

import com.example.mybatis.entity.MUser;

import java.util.List;

/**
 * @Classname MUserService
 * @Description TODO
 * @Date 2020/10/12 4:42 下午
 * @Author z7-x
 */
public interface MUserService {
    /**
     * 查询所有用户
     * @return
     */
    List<MUser> findByMUsers();

    /**
     *  添加用户
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
