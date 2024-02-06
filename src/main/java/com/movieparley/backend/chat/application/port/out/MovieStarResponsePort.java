package com.movieparley.backend.chat.application.port.out;

import com.movieparley.backend.chat.application.domain.model.Utterance;

public interface MovieStarResponsePort {
    Utterance respondTo(Utterance utterance);
}
