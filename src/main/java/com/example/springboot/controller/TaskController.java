package com.example.springboot.controller;

import com.example.springboot.entity.ContactHead;
import com.example.springboot.service.ContactHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * 项目名称：springboot-excel
 * 类 名 称：TaskController
 * 类 描 述：TODO
 * 创建时间：2020/3/17 1:58 下午
 * 创 建 人：apple
 */

@Configuration
@Lazy(false)
@EnableAsync
@EnableScheduling
public class TaskController {

    @Autowired
    private ContactHeadService contactHeadService;

    @Scheduled(cron = "0 29 15 17 3 ?")
    public void executeTask() throws  Exception{
        System.out.println("2020年3月17日下午15：29 task执行了一次！");//验证成功
        List<ContactHead> uidList  =  contactHeadService.getUidList();
        for(ContactHead uid:uidList){
            System.out.println("uid:"+uid);
        }
    }

}
