package com.example.springboot.controller;

import com.example.springboot.entity.ContactHead;
import com.example.springboot.entity.YsProject;
import com.example.springboot.service.ContactHeadService;
import com.example.springboot.service.ProjectService;
import com.example.springboot.utill.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目名称：springboot-excel
 * 类 名 称：ProjectController
 * 类 描 述：TODO
 * 创建时间：2020/3/16 10:44 上午
 * 创 建 人：apple
 */
@RestController
public class ProjectController {

    @Autowired
    private ContactHeadService contactHeadService;
    @Autowired
    private ProjectService projectService;

    @RequestMapping("/readProject")
    @ResponseBody
    /**
     * 功能：直接查询b_contacthead的Uid列，将Uid列插入到ys_project的新增字段中
     */
    public void directReadProject(){
        int result = 0;
        try{
            List<ContactHead> uidList  =  contactHeadService.getUidList();
            projectService.batchInsertProject(uidList);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if(result>0){
            System.out.println("ys_Project data import success");
        }else
            System.out.println("ys_Project data import error");
    }
}
