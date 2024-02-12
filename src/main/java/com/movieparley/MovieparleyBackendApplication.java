package com.movieparley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class MovieparleyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieparleyBackendApplication.class, args);
    }

}
