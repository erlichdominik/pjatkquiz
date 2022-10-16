package com.pjatk.pjatkquiz.quiz.dto;

public class QuizNotFoundException extends RuntimeException {
    public QuizNotFoundException(long quizId) {
        super("quiz with id: " + quizId + " was not found", null, false, true);
    }

    public QuizNotFoundException(String quizName) {
        super("quiz with name: " + quizName + " was not found", null, false ,true);
    }
}
