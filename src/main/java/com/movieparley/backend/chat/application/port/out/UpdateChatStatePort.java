package com.movieparley.backend.chat.application.port.out;

import com.movieparley.backend.chat.application.domain.model.Chat;
import com.movieparley.backend.chat.application.domain.model.Utterance;

public interface UpdateChatStatePort {
    void update(Chat.ChatID chatID, Utterance utterance);
}
