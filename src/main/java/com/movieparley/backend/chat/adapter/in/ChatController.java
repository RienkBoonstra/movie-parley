package com.movieparley.backend.chat.adapter.in;

import com.movieparley.backend.chat.application.port.in.StartChatUseCase;
import com.movieparley.backend.chat.application.domain.model.Utterance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final StartChatUseCase startChatUseCase;

    public ChatController(StartChatUseCase startChatUseCase) {
        this.startChatUseCase = startChatUseCase;
    }

    @GetMapping("dead_or_alive")
    public String deadOrAlive() {
        return "Oh, god still alive!";
    }

    @PostMapping("chat")
    public ResponseEntity<StartChatUseCase.StartChatResponse> startChat(@RequestBody Utterance utterance) {
        StartChatUseCase.StartChatResponse response = startChatUseCase.startChat(utterance);
        return ResponseEntity.ok(response);
    }
}
