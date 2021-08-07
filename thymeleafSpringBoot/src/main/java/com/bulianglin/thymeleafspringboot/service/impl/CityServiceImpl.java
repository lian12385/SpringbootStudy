package com.bulianglin.thymeleafspringboot.service.impl;

import com.bulianglin.thymeleafspringboot.bean.City;
import com.bulianglin.thymeleafspringboot.mapper.CityMapper;
import com.bulianglin.thymeleafspringboot.service.CityService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;

    Counter counter;

    public CityServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("cityService.saveCity.count");
    }

    public City getById(Long id){
        return cityMapper.getById(id);
    }
    public void saveCity(City city){
        counter.increment();
        cityMapper.insert(city);
    }
}
