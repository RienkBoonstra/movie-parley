package com.movieparley.backend.chat.adapter.in;

import com.movieparley.backend.chat.application.port.in.StartChatUseCase;
import com.movieparley.backend.chat.application.domain.model.Utterance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final StartChatUseCase startChatUseCase;

    public ChatController(StartChatUseCase startChatUseCase) {
        this.startChatUseCase = startChatUseCase;
    }

    @PostMapping("chat")
    public ResponseEntity<StartChatUseCase.StartChatResponse> startChat(Utterance utterance) {
        StartChatUseCase.StartChatResponse response = startChatUseCase.startChat(utterance);
        return ResponseEntity.ok(response);
    }
}
