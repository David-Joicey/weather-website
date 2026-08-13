package com.davidjoicey.backend.model;

public record WeatherData(
    // ISO date: 2026-08-12
    String date,
    double maxTemp,
    double minTemp,
    int humidity,
    double precipitation,
    int weatherCode
) {}