package com.davidjoicey.backend.model;

public record WeatherData(
    // ISO date: 2026-08-12
    String date,
    double temperature,
    double humidity,
    double precipitation,
    int weathercode
) {}