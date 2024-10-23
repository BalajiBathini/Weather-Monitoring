package com.WeatherMonitoring.wm.controller;

import java.time.LocalDate;
import java.util.List;

import com.WeatherMonitoring.wm.service.WeatherScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.WeatherMonitoring.wm.exception.ResourceNotFoundException;
import com.WeatherMonitoring.wm.model.WeatherSummary;
import com.WeatherMonitoring.wm.service.AlertService;
import com.WeatherMonitoring.wm.service.WeatherSummaryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller class for handling weather-related requests.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private WeatherSummaryService weatherSummaryService;

    @Autowired
    private AlertService alertService;
    @Autowired
    private WeatherScheduler weatherScheduler;

    /**
     * Endpoint to get weather summaries for a specific city.
     *
     * @param city the name of the city
     * @return list of weather summaries for the specified city
     */
    @GetMapping("/summaries/{city}")
    public ResponseEntity<List<WeatherSummary>> getWeatherSummaries(@PathVariable String city) {
        logger.info("Received request for weather summaries for city: {}", city);
        List<WeatherSummary> summaries = weatherSummaryService.getSummariesByCity(city);

        if (summaries.isEmpty()) {
            logger.warn("No weather summaries found for city: {}", city);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        logger.info("Retrieved {} summaries for city: {}", summaries.size(), city);
        return ResponseEntity.ok(summaries);
    }

    @PostMapping("/fetchWeatherData")
    public ResponseEntity<String> triggerFetchWeatherData() {
        weatherScheduler.fetchWeatherData(); // This calls the method directly
        return ResponseEntity.ok("Triggered weather data fetch.");
    }

    /**
     * Endpoint to check if an alert should be triggered for a specific city and date.
     *
     * @param city the name of the city
     * @param date the date to check
     * @return response indicating if an alert is triggered
     */
    @GetMapping("/alert/{city}/{date}")
    public ResponseEntity<String> checkAlert(@PathVariable String city, @PathVariable String date) {
        try {
            String alertMessage = alertService.checkAlert(city, LocalDate.parse(date));
            return ResponseEntity.ok(alertMessage);
        } catch (Exception e) {
            logger.error("Error checking alert for city: {} on date: {}: {}", city, date, e.getMessage());
            throw new ResourceNotFoundException("Unable to check alert", e);
        }
    }
}
