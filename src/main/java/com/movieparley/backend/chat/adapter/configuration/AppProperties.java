package com.movieparley.backend.chat.adapter.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app")
public record AppProperties(
        String version
)
{}
