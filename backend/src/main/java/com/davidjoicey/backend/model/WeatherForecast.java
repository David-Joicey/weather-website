package com.davidjoicey.backend.model;

import java.util.List;

public record WeatherForecast(
    String city,
    double latitude,
    double longitude,
    List<WeatherData> weatherData
) {}
