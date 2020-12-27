package com.weather.app.serviceimp;

import com.weather.app.module.CityView;
import com.weather.app.service.ICityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConfigrationCityService implements ICityService {
    @Value("${weather.configration.city}")
    List<String> cities = new ArrayList<>();

    @Override
    public List<CityView> getCities() {
        return cities.stream().map(x -> new CityView(x, x)).collect(Collectors.toList());
    }
}
