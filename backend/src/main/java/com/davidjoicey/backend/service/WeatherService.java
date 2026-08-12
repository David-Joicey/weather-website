package com.davidjoicey.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davidjoicey.backend.infrastructure.client.ApiClient;
import com.davidjoicey.backend.model.WeatherData;
import com.davidjoicey.backend.model.WeatherForecast;

@Service
public class WeatherService {
    private final ApiClient apiClient;

    public WeatherService(ApiClient apiClient){
        this.apiClient = apiClient;
    }
}
