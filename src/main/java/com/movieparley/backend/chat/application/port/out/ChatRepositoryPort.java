package com.movieparley.backend.chat.application.port.out;

import com.movieparley.backend.chat.application.domain.model.Chat;
import com.movieparley.backend.chat.application.domain.model.ChatID;
import com.movieparley.backend.chat.application.domain.model.Utterance;

public interface ChatRepositoryPort {

    ChatID insert(Chat chat);
    void update(ChatID chatID, Utterance utterance);
}
