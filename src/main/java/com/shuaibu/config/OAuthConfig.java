package com.shuaibu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class OAuthConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/v1/candidates", "/api/v1/jobs", "/api/v1/jobs/get/{id}", "/api/v1/recruiters/get/{id}", "/api/v1/recruiters")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .oauth2Login(withDefaults())
            ;
            
        return http.build();
    }
}
