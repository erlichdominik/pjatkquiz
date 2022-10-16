package com.pjatk.pjatkquiz.quiz.dto;

import java.util.Set;

public record QuizDto(long id, String quizName, Set<QuestionDto> questions) {

}
