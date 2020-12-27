package com.weather.app.service;

import com.weather.app.module.CityView;

import java.util.List;

public interface ICityService {
    List<CityView> getCities();
}
