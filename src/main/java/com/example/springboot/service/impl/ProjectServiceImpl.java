package com.example.springboot.service.impl;

import com.example.springboot.entity.ContactHead;
import com.example.springboot.entity.YsProject;
import com.example.springboot.repository.ProjectRepositoty;
import com.example.springboot.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 项目名称：springboot-excel
 * 类 名 称：ProjectServiceImpl
 * 类 描 述：TODO
 * 创建时间：2020/3/16 11:01 上午
 * 创 建 人：apple
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepositoty projectRepositoty;

    @Override
    public int batchInsertProject(List<ContactHead> uidList) {
        List<YsProject> uList = new ArrayList<>();
            YsProject ysProject = new YsProject();

        uidList.forEach(contactHead -> {
            ysProject.setBcontactheadUID(contactHead.getUid());
            uList.add(ysProject);
        });
        projectRepositoty.saveAll(uList);
        return 1;
    }
}
