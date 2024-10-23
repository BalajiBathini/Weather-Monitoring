package com.WeatherMonitoring.wm.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing the summary of weather data for a specific city and date.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "weather_summaries")
public class WeatherSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "City")
    private String city;

    @Column(name = "Average Temp")
    private double averageTemp;

    @Column(name = "Max Temp")
    private double maxTemp;

    @Column(name = "Min Temp")
    private double minTemp;

    @Column(name = "Dominant Weather")
    private String dominantWeather;

    @Column(name = "Date")
    private LocalDate date;
}
