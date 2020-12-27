package com.weather.app.service;

import com.weather.app.module.WeatherResponseView;

public interface IWeatherApi {
    WeatherResponseView getWeatherByCityName(String cityName) throws Exception;
}
