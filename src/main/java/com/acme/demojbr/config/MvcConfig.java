package com.acme.demojbr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


    @Autowired
    Environment env;

    @Bean
    @Profile({"dev", "devlocal","prodlocal", "local","prod"}) //da togliere il prod
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedHeaders("authorization","Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                                "Access-Control-Request-Headers")
                        .exposedHeaders("Access-Control-Allow-Origin","X-Get-Header","content-disposition")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedMethods("HEAD","OPTIONS", "GET", "PUT", "POST", "DELETE", "PATCH");
            }
        };
    }

}
