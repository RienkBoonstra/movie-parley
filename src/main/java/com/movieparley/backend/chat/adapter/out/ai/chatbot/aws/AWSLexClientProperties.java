package com.movieparley.backend.chat.adapter.out.ai.chatbot.aws;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "ai.chatbot.aws.lex")
public record AWSLexClientProperties(
        String botId,
        String botAliasId,
        String localeId,
        String accessKey,
        String secretKey,
        String region
)
{}
