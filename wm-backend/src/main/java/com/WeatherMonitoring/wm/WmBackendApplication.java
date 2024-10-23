package com.WeatherMonitoring.wm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WmBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WmBackendApplication.class, args);
	}

}
