package com.pjatk.pjatkquiz.quiz.domain;

import com.pjatk.model.IsCorrect;
import com.pjatk.model.Name;
import com.pjatk.pjatkquiz.quiz.dto.AnswerId;
import lombok.Getter;

@Getter
class AnswerSnapshot {
    private AnswerId id;
    private Name name;
    private IsCorrect isCorrect;

    AnswerSnapshot(AnswerId id, Name name, IsCorrect isCorrect) {
        this.id = id;
        this.name = name;
        this.isCorrect = isCorrect;
    }

    public AnswerSnapshot() {}


}
