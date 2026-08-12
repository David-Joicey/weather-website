package com.davidjoicey.backend.infrastructure.dto;

import java.util.List;

public record Daily(
    List<String> time,
    List<Double> temperature_2m_max,
    List<Integer> weathercode
) {}
