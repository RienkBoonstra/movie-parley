package com.movieparley.backend.chat.adapter.out.ai.chatbot.dummy;

import com.movieparley.backend.chat.application.domain.model.Utterance;
import com.movieparley.backend.chat.application.port.out.MovieStarResponsePort;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Profile("dummy")
@Component
public class DummyMovieStarAdapter implements MovieStarResponsePort {

    @Override
    public Utterance respondTo(Utterance utterance) {
        return new Utterance("They were all alive until they met you, Frank (dummy response).");
    }
}
