package com.WeatherMonitoring.wm.service;

import com.WeatherMonitoring.wm.model.WeatherSummary;
import com.WeatherMonitoring.wm.repository.WeatherSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Service class for managing weather alerts based on temperature thresholds.
 */
@Service
public class AlertService {

    private static final double TEMP_THRESHOLD = 35.0;  // Temperature threshold for alert

    @Autowired
    private WeatherSummaryRepository weatherSummaryRepository;

    /**
     * Check if an alert should be triggered for a specific city based on the temperature.
     *
     * @param city the name of the city
     * @param date the date to check
     * @return alert message if triggered
     */
    public String checkAlert(String city, LocalDate date) {
        Optional<WeatherSummary> summaryOptional = weatherSummaryRepository.findByCityAndDate(city, date);
        if (summaryOptional.isPresent()) {
            WeatherSummary summary = summaryOptional.get();
            if (summary.getMaxTemp() > TEMP_THRESHOLD) {
                return "Alert triggered! Max temperature of " + summary.getMaxTemp() + "°C exceeded threshold.";
            }
        }
        return "No alert.";
    }
}
