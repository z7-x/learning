package com.example.mybatis.service.impl;

import com.example.mybatis.entity.MUser;
import com.example.mybatis.mapper.MUserMapper;
import com.example.mybatis.service.MUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @Classname MUserServiceImpl
 * @Description TODO
 * @Date 2020/10/12 4:42 下午
 * @Author z7-x
 */
@Service
@Transactional
public class MUserServiceImpl  implements MUserService {

    @Autowired
    private MUserMapper mUserMapper;

    @Override
    public List<MUser> findByMUsers() {
//        return mUserMapper.selectAll();
        return mUserMapper.findByMUsers();
    }

}
