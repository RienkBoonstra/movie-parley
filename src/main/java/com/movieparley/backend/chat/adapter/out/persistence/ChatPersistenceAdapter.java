package com.movieparley.backend.chat.adapter.out.persistence;

import com.movieparley.backend.chat.adapter.out.persistence.mongodb.ChatMongoRepository;
import com.movieparley.backend.chat.application.domain.model.Chat;
import com.movieparley.backend.chat.application.domain.model.Utterance;
import com.movieparley.backend.chat.application.port.out.StoreNewChatPort;
import com.movieparley.backend.chat.application.port.out.UpdateChatStatePort;
import org.springframework.stereotype.Repository;

@Repository
public class ChatPersistenceAdapter implements StoreNewChatPort, UpdateChatStatePort {

    private final ChatMongoRepository chatMongoRepository;

    public ChatPersistenceAdapter(ChatMongoRepository chatMongoRepository) {
        this.chatMongoRepository = chatMongoRepository;
    }

    @Override
    public void store(Chat chat) {
        chatMongoRepository.insert(chat);
    }

    @Override
    public void update(Chat.ChatID chatID, Utterance utterance) {

    }
}
