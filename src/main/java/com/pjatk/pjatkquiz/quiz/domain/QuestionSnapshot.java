package com.pjatk.pjatkquiz.quiz.domain;

import lombok.Getter;

import java.util.Set;

@Getter
class QuestionSnapshot {
    private long questionId;
    private String quizName;
    private Set<AnswerSnapshot> answers;

    QuestionSnapshot(long questionId, String quizName, Set<AnswerSnapshot> answers) {
        this.questionId = questionId;
        this.quizName = quizName;
        this.answers = answers;
    }

    public QuestionSnapshot() {}
}
