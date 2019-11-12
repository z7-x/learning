package com.example.springboot.service;

import com.example.springboot.pojo.CityModel;

import java.util.List;

public interface ICityService {
    int addCity(CityModel cityModel);
    List<CityModel> findCityList();
}
