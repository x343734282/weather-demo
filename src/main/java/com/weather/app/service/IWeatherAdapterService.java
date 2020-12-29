package com.weather.app.service;

import com.weather.app.module.WeatherResponseView;

public interface IWeatherAdapterService {
    WeatherResponseView getWeatherByCityName(String cityName) throws Exception;
}
