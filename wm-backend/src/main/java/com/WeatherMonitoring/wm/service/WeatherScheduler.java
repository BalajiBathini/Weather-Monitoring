package com.WeatherMonitoring.wm.service;

import com.WeatherMonitoring.wm.controller.WeatherController;
import com.WeatherMonitoring.wm.model.WeatherResponse;
import com.WeatherMonitoring.wm.model.WeatherSummary;
import com.WeatherMonitoring.wm.repository.WeatherSummaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Service class for scheduling weather data fetching from the OpenWeatherMap API.
 */
@Service
public class WeatherScheduler {
    private static final Logger logger = LoggerFactory.getLogger(WeatherScheduler.class);
    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherSummaryRepository weatherSummaryRepository;

    /**
     * Scheduled method to fetch weather data every 5 minutes.
     */
    @Scheduled(fixedRate = 300000)  // Every 5 minutes
    public void fetchWeatherData() {
        String[] cities = {"Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad"};

        for (String city : cities) {
            WeatherResponse weatherResponse = weatherService.getWeather(city);
            if (weatherResponse != null && weatherResponse.getMain() != null) {
                double tempCelsius = weatherService.convertKelvinToCelsius(weatherResponse.getMain().getTemp());
                double tempFahrenheit = weatherService.convertKelvinToFahrenheit(weatherResponse.getMain().getTemp());

                // Create or update daily weather summary
                LocalDate today = LocalDate.now();
                Optional<WeatherSummary> optionalSummary = weatherSummaryRepository.findByCityAndDate(city, today);

                if (optionalSummary.isEmpty()) {
                    // No existing summary for today, create a new one
                    WeatherSummary summary = new WeatherSummary();
                    summary.setCity(city);
                    summary.setAverageTemp(tempCelsius);
                    summary.setMaxTemp(tempCelsius);
                    summary.setMinTemp(tempCelsius);
                    summary.setDominantWeather(weatherResponse.getWeather().get(0).getMain());
                    summary.setDate(today);
                    weatherSummaryRepository.save(summary);
                } else {
                    // Update existing summary
                    WeatherSummary summary = optionalSummary.get();
                    summary.setAverageTemp((summary.getAverageTemp() + tempCelsius) / 2); // Rolling average
                    summary.setMaxTemp(Math.max(summary.getMaxTemp(), tempCelsius));
                    summary.setMinTemp(Math.min(summary.getMinTemp(), tempCelsius));
                    weatherSummaryRepository.save(summary);
                }
                logger.info("Weather data for {} fetched successfully.", city);
            }
            else {
                logger.warn("Failed to fetch weather data for {}", city);
            }
        }
    }
}
