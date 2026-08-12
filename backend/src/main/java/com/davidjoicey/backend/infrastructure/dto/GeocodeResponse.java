package com.davidjoicey.backend.infrastructure.dto;

import java.util.List;

public record GeocodeResponse(
    List<GeocodeResult> results
) {}
