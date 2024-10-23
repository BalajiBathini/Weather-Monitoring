package com.WeatherMonitoring.wm.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * Application configuration class.
 */
@Configuration
public class RestTemplateConfig {
    /**
     * Bean for RestTemplate used for making API calls.
     *
     * @return RestTemplate instance
     */
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
