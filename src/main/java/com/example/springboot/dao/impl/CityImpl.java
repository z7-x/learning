package com.example.springboot.dao.impl;

import com.example.springboot.dao.ICity;
import com.example.springboot.pojo.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityImpl implements ICity {


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;//第一种方式连接数据库:jdbcTemplate


    @Override
    public int addCity(CityModel cityModel) {
        String sql = "INSERT INTO City VALUES (:id, :district, :monitorTime, :pm10, :pm25, :monitoringStation, :createDate)";

        Map<String, Object> param = new HashMap<>();
        param.put("id",cityModel.getId());
        param.put("district",cityModel.getDistrict());
        param.put("monitorTime",cityModel.getMonitorTime());
        param.put("pm10",cityModel.getPm10());
        param.put("pm25",cityModel.getPm25());
        param.put("monitoringStation",cityModel.getMonitoringStation());
        param.put("createDate",cityModel.getCreateDate());

        return jdbcTemplate.update(sql, param);
    }

    @Override
    public List<CityModel> findCityList() {
        String sql = "SELECT * FROM City";
        List<CityModel> cityModelList = new ArrayList<>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                CityModel cityModel = new CityModel();
                cityModel.setId(resultSet.getInt("id"));
                cityModel.setDistrict(resultSet.getString("district"));
                cityModel.setMonitorTime(resultSet.getDate("monitorTime"));
                cityModel.setPm10(resultSet.getInt("pm10"));
                cityModel.setPm25(resultSet.getInt("pm25"));
                cityModel.setMonitoringStation(resultSet.getString("monitoringStation"));
                cityModel.setCreateDate(resultSet.getDate("createDate"));
            }
        });
        return cityModelList;
    }
}
