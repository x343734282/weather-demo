package com.weather.app.controller;

import com.weather.app.module.CitySource;
import com.weather.app.module.WeatherResponseView;
import com.weather.app.service.IWeatherApi;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
//@Log4j
public class HomeController {
    private final Log logger = LogFactory.getLog(HomeController.class);
    private final IWeatherApi weatherApi;

    public HomeController(IWeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    @GetMapping(path = "/api/v1/realtime/weather", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Object> getWeather(@RequestParam String city) {

        WeatherResponseView weatherResponseView = null;
        try {
            weatherResponseView = this.weatherApi.getWeatherByCityName(city);
        } catch (Exception e) {
            //TODO;
            logger.error(e);
        }

        return new ResponseEntity<>(weatherResponseView, HttpStatus.OK);
    }

    @GetMapping(path = "/api/v1/cities", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<CitySource>> getCities() {
        this.logger.error("debug");

        return new ResponseEntity<>(Collections.singletonList(new CitySource("aef", "d")), HttpStatus.OK);
    }
}
