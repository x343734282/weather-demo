package com.weather.app.serviceimp;

import com.weather.app.config.WeatherApiConfigration;
import com.weather.app.module.WeatherResponseView;
import com.weather.app.service.IWeatherApi;
import com.weather.app.weatherapi.CurrentJsonResponse;
import com.weather.app.weatherapi.WeatherApi;
import org.springframework.stereotype.Service;

@Service()
public class WeatherApiImpl implements IWeatherApi {
    private final WeatherApiConfigration weatherApiConfigration;

    public WeatherApiImpl(WeatherApiConfigration weatherApiConfigration) {
        this.weatherApiConfigration = weatherApiConfigration;
    }

    @Override
    public WeatherResponseView getWeatherByCityName(String cityName) throws Exception {

        CurrentJsonResponse currentJsonResponse = WeatherApi.RealtimeWeatherApi(cityName, weatherApiConfigration.getKey());

        return new WeatherResponseView(currentJsonResponse.getLocation().getName()
                , currentJsonResponse.getCurrent().getLastUpdated()
                , currentJsonResponse.getCurrent().getCondition().getText()
                , currentJsonResponse.getCurrent().getTempC().toString()
                , currentJsonResponse.getCurrent().getWindKph().toString());
    }

}
