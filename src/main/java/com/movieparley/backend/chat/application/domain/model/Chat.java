package com.movieparley.backend.chat.application.domain.model;

import java.util.UUID;

public class Chat {

    private final ChatID id;

    public Chat(ChatID id) {
        this.id = id;
    }


    public record ChatID(String id) {}
}
