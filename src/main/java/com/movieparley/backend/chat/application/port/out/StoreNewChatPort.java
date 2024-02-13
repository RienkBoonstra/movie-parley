package com.movieparley.backend.chat.application.port.out;

import com.movieparley.backend.chat.application.domain.model.Chat;

public interface StoreNewChatPort {

    void store(Chat chat);
}
