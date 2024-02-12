package com.movieparley.backend.chat.adapter.out.ai.chatbot;


import com.movieparley.backend.chat.application.domain.model.Utterance;

public interface ChatbotClient {

    String recognizeIntent(String text);
}
