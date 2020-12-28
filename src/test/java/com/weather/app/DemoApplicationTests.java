package com.weather.app;

import com.weather.app.module.CityView;
import com.weather.app.module.WeatherResponseView;
import com.weather.app.service.ICityService;
import com.weather.app.service.IWeatherApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
//@TestPropertySource("classpath:application-test.properties")
class DemoApplicationTests {

    @Autowired
    private IWeatherApi weatherApi;

    @Autowired
    private ICityService cityService;

    @Test
    void weatherApiTest() {
        WeatherResponseView responseView = null;
        try {
            responseView = this.weatherApi.getWeatherByCityName("dalian");

        } catch (Exception e) {

        }

        Assert.notNull(responseView, "api right key case error.");
    }


    @Test
    void citySource() {
        List<CityView> cities = this.cityService.getCities();

        Assert.isTrue(cities.size() == 3, "city service error.");
    }

}
