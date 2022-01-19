package com.zkdlu.tdd.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableWebMvc
public class CorsConfiguration extends WebMvcConfigurationSupport {
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST")
                .allowedOrigins("http://localhost:9090")
                .exposedHeaders("x-auth-token");
    }
}
