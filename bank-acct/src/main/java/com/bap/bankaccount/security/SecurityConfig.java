package com.bap.bankaccount.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.bap.bankaccount.security.filter.AuthenticationFilter;
import com.bap.bankaccount.security.filter.ExceptionHandlerFilter;
import com.bap.bankaccount.security.filter.JWTAuthorizationFilter;
import com.bap.bankaccount.security.manager.CustomAuthenticationManager;

import lombok.AllArgsConstructor;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationManager customAuthenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/login");

        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/h2/**").permitAll()
                .requestMatchers(HttpMethod.POST, SecurityConstants.REGISTER_PATH).permitAll()
                .anyRequest().authenticated()
            )
            .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.disable()) // Disable X-Frame-Options
            )
            .csrf(csrf -> csrf.disable()) // Disable CSRF protection
            .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
            .addFilter(authenticationFilter)
            .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
            .sessionManagement(sessionManagement -> sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Set session creation policy
                // Add other session management configurations as needed
            );
        return http.build();
    }
}
