package com.davidjoicey.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.davidjoicey.backend.model.WeatherForecast;
import com.davidjoicey.backend.service.WeatherService;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{location}")
    public WeatherForecast getWeather(@PathVariable String location) {
        return weatherService.getForecast(location);

    }
}
