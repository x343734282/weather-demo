package com.weather.app.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "weather-api")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherApiConfigration {
    private String key;
}
