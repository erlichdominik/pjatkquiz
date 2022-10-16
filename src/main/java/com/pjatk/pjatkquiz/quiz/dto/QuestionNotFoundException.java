package com.pjatk.pjatkquiz.quiz.dto;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(long questionId) {
        super("question with id: " + questionId + " was not found", null, false, true);
    }

    public QuestionNotFoundException() {
        super("there are no questions", null, false, true);
    }
}
