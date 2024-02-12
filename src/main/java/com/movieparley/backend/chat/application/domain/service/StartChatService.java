package com.movieparley.backend.chat.application.domain.service;

import com.movieparley.backend.chat.application.domain.model.Chat;
import com.movieparley.backend.chat.application.domain.model.ChatID;
import com.movieparley.backend.chat.application.domain.model.Utterance;
import com.movieparley.backend.chat.application.port.in.StartChatUseCase;
import com.movieparley.backend.chat.application.port.out.ChatRepositoryPort;
import com.movieparley.backend.chat.application.port.out.MovieStarResponsePort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StartChatService implements StartChatUseCase {

    private final MovieStarResponsePort movieStarResponsePort;

    private final ChatRepositoryPort chatRepositoryPort;

    public StartChatService(MovieStarResponsePort movieStarResponsePort, ChatRepositoryPort chatRepositoryPort) {
        this.movieStarResponsePort = movieStarResponsePort;
        this.chatRepositoryPort = chatRepositoryPort;
    }

    public StartChatResponse startChat(Utterance utterance) {
        ChatID chatId = new ChatID(UUID.randomUUID());
        Utterance response = movieStarResponsePort.respondTo(utterance);
        // TODO: persist the chat
        return new StartChatResponse(response, chatId);
    }
}
