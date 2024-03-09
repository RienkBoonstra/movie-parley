package com.movieparley.backend.chat.adapter.out.persistence.mongodb;

import com.movieparley.backend.chat.application.domain.model.Chat;
import com.movieparley.backend.chat.application.domain.model.Utterance;
import com.movieparley.backend.chat.application.port.out.StoreNewChatPort;
import com.movieparley.backend.chat.application.port.out.UpdateChatStatePort;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Profile("mongo")
@Repository
public class MongoDbChatPersistenceAdapter implements StoreNewChatPort, UpdateChatStatePort {

    private final MongoTemplate mongoTemplate;
    public MongoDbChatPersistenceAdapter(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void store(Chat chat) {
        mongoTemplate.insert(chat);
    }

    @Override
    public void update(Chat.ChatID chatID, Utterance utterance) {

    }
}
