package com.movieparley.backend.chat.application.domain.service;

import com.movieparley.backend.chat.application.domain.model.Chat;
import com.movieparley.backend.chat.application.domain.model.Utterance;
import com.movieparley.backend.chat.application.port.in.StartChatUseCase;
import com.movieparley.backend.chat.application.port.out.StoreNewChatPort;
import com.movieparley.backend.chat.application.port.out.MovieStarResponsePort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StartChatService implements StartChatUseCase {

    private final MovieStarResponsePort movieStarResponsePort;

    private final StoreNewChatPort storeNewChatPort;

    public StartChatService(MovieStarResponsePort movieStarResponsePort, StoreNewChatPort storeNewChatPort) {
        this.movieStarResponsePort = movieStarResponsePort;
        this.storeNewChatPort = storeNewChatPort;
    }

    public StartChatResponse startChat(Utterance utterance) {
        Chat.ChatID chatId = new Chat.ChatID(UUID.randomUUID().toString());
        Utterance response = movieStarResponsePort.respondTo(utterance);
        storeNewChatPort.store(new Chat(chatId));
        return new StartChatResponse(response, chatId);
    }
}
