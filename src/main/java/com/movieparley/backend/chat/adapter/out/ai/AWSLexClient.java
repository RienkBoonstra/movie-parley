package com.movieparley.backend.chat.adapter.out.ai;

import com.movieparley.backend.chat.application.domain.model.Utterance;
import com.movieparley.backend.chat.application.port.out.MovieStarResponsePort;
import org.springframework.stereotype.Component;

@Component
public class AWSLexClient implements MovieStarResponsePort {
    @Override
    public Utterance respondTo(Utterance utterance) {
        return null;
    }
}
