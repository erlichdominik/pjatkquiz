package com.pjatk.pjatkquiz.quiz.dto;

import com.pjatk.model.Name;

import java.util.Set;

public record QuestionDto(QuestionId id, Name quizName, Set<AnswerDto> answers) {
}
