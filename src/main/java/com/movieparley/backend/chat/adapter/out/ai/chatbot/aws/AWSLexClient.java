package com.movieparley.backend.chat.adapter.out.ai.chatbot.aws;

import com.movieparley.backend.chat.adapter.out.ai.chatbot.ChatbotClient;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lexruntimev2.LexRuntimeV2Client;
import software.amazon.awssdk.services.lexruntimev2.model.RecognizeTextRequest;
import software.amazon.awssdk.services.lexruntimev2.model.RecognizeTextResponse;

import java.util.UUID;

@Component
public class AWSLexClient implements ChatbotClient {

    private final AWSLexClientProperties properties;

    public AWSLexClient(AWSLexClientProperties properties) {
        this.properties = properties;
    }
    @Override
    public String recognizeIntent(String text) {
        String sessionId = UUID.randomUUID().toString();
        Region region = Region.of(properties.region());

        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(properties.accessKey(), properties.secretKey());
        AwsCredentialsProvider awsCredentialsProvider = StaticCredentialsProvider.create(awsCreds);

        LexRuntimeV2Client lexV2Client = LexRuntimeV2Client
                .builder()
                .credentialsProvider(awsCredentialsProvider)
                .region(region)
                .build();

        RecognizeTextRequest recognizeTextRequest = getRecognizeTextRequest(properties.botId(), properties.botAliasId(), properties.localeId(), sessionId, text);
        RecognizeTextResponse recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);

        var response = new StringBuilder();
        recognizeTextResponse.messages().forEach(message -> {
            response.append(message.content());
        });

        return response.toString();
    }
    private RecognizeTextRequest getRecognizeTextRequest(String botId, String botAliasId, String localeId, String sessionId, String userInput) {
        return RecognizeTextRequest.builder()
                .botAliasId(botAliasId)
                .botId(botId)
                .localeId(localeId)
                .sessionId(sessionId)
                .text(userInput)
                .build();
    }
}
