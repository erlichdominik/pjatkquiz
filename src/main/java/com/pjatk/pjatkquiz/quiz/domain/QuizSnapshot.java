package com.pjatk.pjatkquiz.quiz.domain;

import lombok.Getter;

import java.util.Set;

@Getter
class QuizSnapshot {
    private long id;
    private String quizName;
    private Set<QuestionSnapshot> questions;

    QuizSnapshot(long id, String quizName, Set<QuestionSnapshot> questions) {
        this.id = id;
        this.quizName = quizName;
        this.questions = questions;
    }

    public QuizSnapshot() {}
}
