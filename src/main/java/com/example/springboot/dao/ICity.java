package com.example.springboot.dao;

import com.example.springboot.pojo.CityModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICity {

    int addCity(CityModel cityModel);

    List<CityModel> findCityList();
}
