package com.movieparley.backend.chat.application.domain.service;

import com.movieparley.backend.chat.application.domain.model.Utterance;
import com.movieparley.backend.chat.application.port.in.StartChatUseCase;
import com.movieparley.backend.chat.application.port.out.ChatRepositoryPort;
import com.movieparley.backend.chat.application.port.out.MovieStarResponsePort;
import org.springframework.stereotype.Component;

@Component
public class StartChatService implements StartChatUseCase {

    private final MovieStarResponsePort movieStarResponsePort;

    private final ChatRepositoryPort chatRepositoryPort;

    public StartChatService(MovieStarResponsePort movieStarResponsePort, ChatRepositoryPort chatRepositoryPort) {
        this.movieStarResponsePort = movieStarResponsePort;
        this.chatRepositoryPort = chatRepositoryPort;
    }

    public StartChatResponse startChat(Utterance utterance) {
        return null;
    }
}
