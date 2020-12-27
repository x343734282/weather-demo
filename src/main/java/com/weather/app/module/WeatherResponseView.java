package com.weather.app.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponseView {
    private String city;
    private String updateTime;
    private String weatherStatus;
    private String temperature;
    private String windSpeed;
}
