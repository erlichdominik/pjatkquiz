package com.pjatk.pjatkquiz.quiz.dto;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(QuestionId questionId) {
        super("question with id: " + questionId.getValue().toString() + " was not found", null, false, true);
    }
}
