package com.movieparley.backend.chat.adapter.out.repository;

import com.movieparley.backend.chat.application.domain.model.Chat;
import com.movieparley.backend.chat.application.domain.model.ChatID;
import com.movieparley.backend.chat.application.domain.model.Utterance;
import com.movieparley.backend.chat.application.port.out.ChatRepositoryPort;
import org.springframework.stereotype.Repository;

@Repository
public class MongoDBChatRepository implements ChatRepositoryPort {
    @Override
    public ChatID insert(Chat chat) {
        return null;
    }

    @Override
    public void update(ChatID chatID, Utterance utterance) {

    }
}
