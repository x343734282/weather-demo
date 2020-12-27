package com.weather.app.weatherapi;

import lombok.var;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Objects;

public class WeatherApi {
    private final static Log logger = LogFactory.getLog(WeatherApi.class);

    public static CurrentJsonResponse RealtimeWeatherApi(String query, String key) throws Exception {
        var template = new RestTemplate();
        ResponseEntity response = template.exchange("https://api.weatherapi.com/v1/current.json?q=" + query + "&key=" + key, HttpMethod.GET, null, new ParameterizedTypeReference<CurrentJsonResponse>() {
        });

        if (response.getStatusCode() != HttpStatus.OK) {
            logger.error("api call error:" + Objects.requireNonNull(response.getBody()).toString());
            throw new Exception();
        }

        return (CurrentJsonResponse) response.getBody();
    }
}
