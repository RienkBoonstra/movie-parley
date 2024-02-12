package com.movieparley.backend.chat.adapter.out.ai.chatbot;

import com.movieparley.backend.chat.application.domain.model.Utterance;
import com.movieparley.backend.chat.application.port.out.MovieStarResponsePort;
import org.springframework.stereotype.Component;

@Component
public class MovieStarResponseAdapter implements MovieStarResponsePort {

    private final ChatbotClient chatbotClient;

    public MovieStarResponseAdapter(ChatbotClient chatbotClient) {
        this.chatbotClient = chatbotClient;
    }

    @Override
    public Utterance respondTo(Utterance utterance) {

        String text = chatbotClient.recognizeIntent(utterance.text());
        return new Utterance(text);
    }
}
