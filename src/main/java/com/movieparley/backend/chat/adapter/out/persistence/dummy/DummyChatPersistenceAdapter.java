package com.movieparley.backend.chat.adapter.out.persistence.dummy;

import com.movieparley.backend.chat.application.domain.model.Chat;
import com.movieparley.backend.chat.application.domain.model.Utterance;
import com.movieparley.backend.chat.application.port.out.StoreNewChatPort;
import com.movieparley.backend.chat.application.port.out.UpdateChatStatePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("dummy")
@Repository
public class DummyChatPersistenceAdapter implements StoreNewChatPort, UpdateChatStatePort {

    Logger logger = LoggerFactory.getLogger(DummyChatPersistenceAdapter.class);

    @Override
    public void store(Chat chat) {
        logger.info("Dummy insert of a chat.");
    }

    @Override
    public void update(Chat.ChatID chatID, Utterance utterance) {
        logger.info("Dummy update of chat with utterance.");
    }
}
