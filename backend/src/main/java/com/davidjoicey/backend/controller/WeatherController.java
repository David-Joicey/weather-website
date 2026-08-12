package com.davidjoicey.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidjoicey.backend.model.WeatherData;
import com.davidjoicey.backend.model.WeatherForecast;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @GetMapping("/{city}")
    public WeatherForecast getWeather(@PathVariable String city) {

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
