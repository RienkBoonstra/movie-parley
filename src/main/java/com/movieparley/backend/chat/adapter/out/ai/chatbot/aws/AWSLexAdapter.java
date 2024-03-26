package com.movieparley.backend.chat.adapter.out.ai.chatbot.aws;

import com.movieparley.backend.chat.application.domain.model.Utterance;
import com.movieparley.backend.chat.application.port.out.MovieStarResponsePort;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lexruntimev2.LexRuntimeV2Client;
import software.amazon.awssdk.services.lexruntimev2.model.RecognizeTextRequest;
import software.amazon.awssdk.services.lexruntimev2.model.RecognizeTextResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Profile("aws")
@Primary
@Component
public class AWSLexAdapter implements MovieStarResponsePort {
    private final AWSLexClientProperties properties;

    public AWSLexAdapter(AWSLexClientProperties properties) {
        this.properties = properties;
    }

    @Override
    public Utterance respondTo(Utterance utterance) {

        String sessionId = UUID.randomUUID().toString();
        Region region = Region.of(properties.region());

        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(properties.accessKey(), properties.secretKey());
        AwsCredentialsProvider awsCredentialsProvider = StaticCredentialsProvider.create(awsCreds);

        RecognizeTextResponse recognizeTextResponse;
        try (LexRuntimeV2Client lexV2Client = LexRuntimeV2Client
                .builder()
                .credentialsProvider(awsCredentialsProvider)
                .region(region)
                .endpointOverride(new URI("https://aws-lex-service"))
                .build()) {

            RecognizeTextRequest recognizeTextRequest = getRecognizeTextRequest(properties.botId(),
                    properties.botAliasId(), properties.localeId(), sessionId, utterance.text());
            recognizeTextResponse = lexV2Client.recognizeText(recognizeTextRequest);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        var response = new StringBuilder();
        recognizeTextResponse.messages().forEach(message -> {
            response.append(message.content());
        });

        return new Utterance(response.toString());
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
