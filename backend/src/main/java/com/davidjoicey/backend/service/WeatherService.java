package com.davidjoicey.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davidjoicey.backend.model.WeatherData;
import com.davidjoicey.backend.model.WeatherForecast;

@Service
public class WeatherService {
    public WeatherForecast getForecast(String city) {
        List<WeatherData> daily = List.of(
            new WeatherData(15.7, 50.2, 1.3, "cloudy"),
            new WeatherData(20.1, 70.6, 5.0, "Sunny")
        );

        return new WeatherForecast(
            city,
            53.8,
            -1.55,
            daily
        );
    }
}
