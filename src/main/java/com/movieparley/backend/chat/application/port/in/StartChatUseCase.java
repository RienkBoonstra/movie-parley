package com.movieparley.backend.chat.application.port.in;

import com.movieparley.backend.chat.application.domain.model.ChatID;
import com.movieparley.backend.chat.application.domain.model.Utterance;

public interface StartChatUseCase {
    StartChatResponse startChat(Utterance utterance);

    record StartChatResponse(Utterance utterance, ChatID chatID){}
}
