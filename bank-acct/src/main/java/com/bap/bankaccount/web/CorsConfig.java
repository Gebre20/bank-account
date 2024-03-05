package com.bap.bankaccount.web;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Allow requests from localhost:3000
        config.setAllowedMethods(Arrays.asList("*")); // Allow all HTTP methods
        config.setAllowedHeaders(Arrays.asList("*")); // Allow all headers
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}