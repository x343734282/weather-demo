package com.weather.app.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CitySource {
    private String cityCode;
    private String cityName;
}
