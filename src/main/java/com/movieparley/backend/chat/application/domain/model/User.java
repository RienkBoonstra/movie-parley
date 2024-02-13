package com.movieparley.backend.chat.application.domain.model;

public final class User extends Participant {

    private final UserID id;

    public User(UserID id) {
        this.id = id;
    }

    public record UserID(String id) {}
}
