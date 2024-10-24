package com.WeatherMonitoring.wm.service;

import com.WeatherMonitoring.wm.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service class for interacting with the OpenWeatherMap API to fetch weather data.
 */
@Service
public class WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);
    private static final String API_KEY = "fd1d08530a9c3444b2a81aaf3e9dfcdf"; // Replace with your actual API key
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid=" + API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Fetch weather data from the OpenWeatherMap API for the given city name.
     *
     * @param city name of the city
     * @return WeatherResponse containing weather data
     */
    public WeatherResponse getWeather(String city) {
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(API_URL, WeatherResponse.class, city);

        // Check if the response status code indicates success (2xx)
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody(); // Return the body if the response is successful
        } else {
            // Log an error if the response was not successful
            logger.error("Failed to fetch weather data: {}", response.getStatusCode());
            return null; // Return null if the API call was unsuccessful
        }
    }

    // Method to convert temperature from Kelvin to Celsius
    public double convertKelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    // Method to convert temperature from Kelvin to Fahrenheit
    public double convertKelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }
}
