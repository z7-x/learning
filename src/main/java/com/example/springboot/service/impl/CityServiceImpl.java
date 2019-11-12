package com.example.springboot.service.impl;

import com.example.springboot.dao.impl.CityImpl;
import com.example.springboot.pojo.CityModel;
import com.example.springboot.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    @Autowired
    private CityImpl cityImpl;

    @Override
    public int addCity(CityModel cityModel) {
        return cityImpl.addCity(cityModel);
    }

    @Override
    public List<CityModel> findCityList() {
        List<CityModel> cityList = cityImpl.findCityList();
        return cityList;
    }
}
