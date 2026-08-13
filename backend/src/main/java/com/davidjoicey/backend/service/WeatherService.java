package com.davidjoicey.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.davidjoicey.backend.infrastructure.client.ApiClient;
import com.davidjoicey.backend.infrastructure.dto.ForecastResponse;
import com.davidjoicey.backend.infrastructure.dto.GeocodeResponse;
import com.davidjoicey.backend.model.WeatherData;
import com.davidjoicey.backend.model.WeatherForecast;

@Service
public class WeatherService {
    private final ApiClient apiClient;

    public WeatherService(ApiClient apiClient){
        this.apiClient = apiClient;
    }

    public WeatherForecast getForecast(String location){
        GeocodeResponse geocodes = apiClient.geocode(location);

        // Handles getting no data from API call
        if (geocodes.results() == null || geocodes.results().isEmpty()) {
            throw new RuntimeException("Location not found: " + location);
        }

        var topResult = geocodes.results().get(0);

        double latitude = topResult.latitude();
        double longitude = topResult.longitude();

        // DTO to Model
        List<WeatherData> dailyData = new ArrayList<>();

        ForecastResponse forecast = apiClient.fetchForecast(latitude, longitude);

        var daily = forecast.daily();

        for (int i = 0; i < daily.time().size(); i++) {
            dailyData.add(new WeatherData(
                daily.time().get(i),
                daily.temperature_2m_max().get(i),
                daily.temperature_2m_min().get(i),
                daily.relative_humidity_2m_max().get(i),
                daily.precipitation_sum().get(i),
                daily.weathercode().get(i)
            ));
        }

        return new WeatherForecast(
            location,
            latitude,
            longitude,
            dailyData
        );
    }
}
