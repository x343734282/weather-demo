package com.weather.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "weather-api")
@Setter
@Getter
@AllArgsConstructor
public class WeatherApiConfigration {
    private String key;
}
