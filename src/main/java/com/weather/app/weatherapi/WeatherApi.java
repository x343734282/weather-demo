package com.weather.app.weatherapi;

import lombok.var;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class WeatherApi {
    private final static Log logger = LogFactory.getLog(WeatherApi.class);

    public static CurrentJsonResponse RealtimeWeatherApi(String query, String key) throws Exception {
        var template = new RestTemplate();
        ResponseEntity response;

        try {
            response = template.exchange("https://api.weatherapi.com/v1/current.json?q=" + query + "&key=" + key, HttpMethod.GET, null, new ParameterizedTypeReference<CurrentJsonResponse>() {
            });
        } catch (RestClientException e) {
            logger.error("api call error:" + e);
            throw new Exception(e);
        }

        return (CurrentJsonResponse) response.getBody();
    }
}
