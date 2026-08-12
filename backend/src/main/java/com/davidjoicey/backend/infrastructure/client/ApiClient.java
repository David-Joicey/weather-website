package com.davidjoicey.backend.infrastructure.client;

import org.springframework.web.client.RestClient;

import com.davidjoicey.backend.infrastructure.dto.ForecastResponse;
import com.davidjoicey.backend.infrastructure.dto.GeocodeResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiClient {
    private final RestClient restClient = RestClient.create();

    @Value("${openmeteo.forecast.url}")
    private String forecastUrl;

    @Value("${openmeteo.geocode.url}")
    private String geocodeUrl;

    public GeocodeResponse geocode(String city) {
        return restClient.get()
            .uri(geocodeUrl + "?name={city}", city)
            .retrieve()
            .body(GeocodeResponse.class);
    }

    public ForecastResponse fetchForecast(double lat, double lon) {
        return restClient.get()
            .uri(forecastUrl +
                 "?latitude={lat}&longitude={lon}" +
                 "&daily=temperature_2m_max,weathercode",
                 lat, lon)
            .retrieve()
            .body(ForecastResponse.class);
    }
}
