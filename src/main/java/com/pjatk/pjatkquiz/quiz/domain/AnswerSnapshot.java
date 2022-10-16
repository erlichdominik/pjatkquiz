package com.pjatk.pjatkquiz.quiz.domain;

import lombok.Getter;

@Getter
class AnswerSnapshot {
    private long id;
    private String name;
    private boolean isCorrect;

    public AnswerSnapshot(long id, String name, boolean isCorrect) {
        this.id = id;
        this.name = name;
        this.isCorrect = isCorrect;
    }

    public AnswerSnapshot() {}


}
