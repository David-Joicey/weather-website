package com.davidjoicey.backend.infrastructure.dto;

public record GeocodeResult(
    String name,
    double latitude,
    double longitude
) {}
