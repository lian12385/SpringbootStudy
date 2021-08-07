package com.bulianglin.thymeleafspringboot.service;

import com.bulianglin.thymeleafspringboot.bean.City;
import org.springframework.stereotype.Service;

//@Service
public interface CityService {

    City getById(Long id);
    void saveCity(City city);
}
