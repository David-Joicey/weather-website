package com.davidjoicey.backend.model;

public record WeatherData (
    String city,
    double temperature,
    double humidity,
    double precipitation,
    String description
) {}