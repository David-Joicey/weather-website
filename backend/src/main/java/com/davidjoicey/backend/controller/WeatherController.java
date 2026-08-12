package com.davidjoicey.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @PostConstruct
    public void init() {
        System.out.println("WeatherController LOADED");
    }

    @GetMapping("/{city}")
    public String getWeather(@PathVariable String city) {
        return "Weather for " + city;
    }
}
