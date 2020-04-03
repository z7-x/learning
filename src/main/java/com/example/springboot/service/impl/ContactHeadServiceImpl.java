package com.example.springboot.service.impl;

import com.example.springboot.entity.ContactHead;
import com.example.springboot.entity.YsProject;
import com.example.springboot.repository.ContactHeadRepositoty;
import com.example.springboot.service.ContactHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：springboot-excel
 * 类 名 称：ContactHeadServiceImpl
 * 类 描 述：TODO
 * 创建时间：2020/3/16 11:30 上午
 * 创 建 人：apple
 */
@Service
public class ContactHeadServiceImpl implements ContactHeadService {

    @Autowired
    private ContactHeadRepositoty contactHeadRepositoty;
    @Override
    public List<ContactHead> getUidList() {
        List<ContactHead>  contactList = contactHeadRepositoty.findAllByUid();
        return contactList;
    }
}
