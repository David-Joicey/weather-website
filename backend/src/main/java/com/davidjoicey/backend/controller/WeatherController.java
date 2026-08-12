package com.davidjoicey.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidjoicey.backend.model.WeatherForecast;
import com.davidjoicey.backend.service.WeatherService;


@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public WeatherForecast getWeather(@PathVariable String city) {
        return weatherService.getForecast(city);

    }
}
