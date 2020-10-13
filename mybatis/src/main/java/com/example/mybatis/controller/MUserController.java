package com.example.mybatis.controller;

import com.example.mybatis.entity.MUser;
import com.example.mybatis.service.MUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname MUserController
 * @Description TODO
 * @Date 2020/10/12 4:47 下午
 * @Author z7-x
 */
@RestController
@RequestMapping("/mUser")
@Api(tags = "用户信息", description = "用户信息")
public class MUserController {

    @Autowired
    private MUserService mUserService;

    @ApiOperation(value = "查询全部用户信息", notes = "查询全部用户信息")
    @RequestMapping(method = RequestMethod.GET, value = "/findAll")
    public List<MUser> findAll(){
        return mUserService.findByMUsers();
    }
}
