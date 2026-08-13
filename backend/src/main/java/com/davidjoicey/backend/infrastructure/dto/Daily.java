package com.davidjoicey.backend.infrastructure.dto;

import java.util.List;

public record Daily(
    List<String> time,
    List<Double> temperature_2m_max,
    List<Double> temperature_2m_min,
    List<Integer> relative_humidity_2m_max,
    List<Double> precipitation_sum,
    List<Integer> weathercode
) {}
