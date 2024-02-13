package com.movieparley.backend.chat.adapter.out.persistence.mongodb;

import com.movieparley.backend.chat.application.domain.model.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMongoRepository extends MongoRepository<Chat, String> {
}
