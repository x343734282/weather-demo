package com.weather.app.weatherapi;

import com.weather.app.config.WeatherApiConfigration;
import com.weather.app.module.WeatherResponseView;
import com.weather.app.service.IWeatherAdapterService;
import lombok.var;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service()
public class WeatherApiServiceImpl implements IWeatherAdapterService {
    private final WeatherApiConfigration weatherApiConfigration;
    private final static Log logger = LogFactory.getLog(WeatherApiServiceImpl.class);

    public WeatherApiServiceImpl(WeatherApiConfigration weatherApiConfigration) {
        this.weatherApiConfigration = weatherApiConfigration;
    }

    @Override
    public WeatherResponseView getWeatherByCityName(String cityName) throws Exception {

        CurrentJsonResponse currentJsonResponse = RealtimeWeatherApi(cityName, weatherApiConfigration.getKey());


        return new WeatherResponseView(currentJsonResponse.getLocation().getName()
                , currentJsonResponse.getCurrent().getLastUpdated()
                , currentJsonResponse.getCurrent().getCondition().getText()
                , currentJsonResponse.getCurrent().getTempC().toString()
                , currentJsonResponse.getCurrent().getWindKph().toString());
    }

    private CurrentJsonResponse RealtimeWeatherApi(String query, String key) throws Exception {
        var template = new RestTemplate();
        ResponseEntity<CurrentJsonResponse> response;

        try {
            response = template.exchange("https://api.weatherapi.com/v1/current.json?q=" + query + "&key=" + key, HttpMethod.GET, null, new ParameterizedTypeReference<CurrentJsonResponse>() {
            });
        } catch (RestClientException e) {
            logger.error("api call error:" + e);
            throw new Exception(e);
        }

        return response.getBody();
    }
}
