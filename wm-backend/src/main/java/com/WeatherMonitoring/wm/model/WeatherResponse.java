package com.WeatherMonitoring.wm.model;

import lombok.*;

import java.util.List;

/**
 * Class representing the weather response from the OpenWeatherMap API.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse {
    private Main main;
    private long dt;  // Date of the weather report
    private List<Weather> weather;

    @Data
    public static class Main {
        private double temp;        // Temperature in Kelvin
        private double feels_like;  // Feels like temperature in Kelvin
    }

    @Data
    public static class Weather {
        private String main;        // Main weather description (e.g., Clear, Rain)
    }

}
