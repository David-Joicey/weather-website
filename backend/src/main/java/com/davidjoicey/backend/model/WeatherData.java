package com.davidjoicey.backend.model;

public record WeatherData (
    double temperature,
    double humidity,
    double precipitation,
    String description
) {}