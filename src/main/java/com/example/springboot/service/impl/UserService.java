package com.example.springboot.service.impl;
import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 *
 * User业务逻辑
 */
@Service
public class UserService {
    @Autowired
    private UserRepositoty userRepositoty;

    public User findUserByName(String name) {
        User user = null;
        try {
            user = userRepositoty.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> find() {
        List<User> list = null;
        try {
            list = userRepositoty.findByColumns();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String deleteUserById(Integer id){
        int  a = userRepositoty.deleteUserById(id);
        return "删除成功";
    }

    public String queryUserById(Integer id ,String name){
        int a = userRepositoty.queryUserById(id,name);
        return "根据id查询成功";
    }

    public String countUserBy(Integer id ,String name ,String password){
        int a = userRepositoty.countUserBy(id,name,password);
        return "成功";
    }
}