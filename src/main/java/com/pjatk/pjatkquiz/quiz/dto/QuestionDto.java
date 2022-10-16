package com.pjatk.pjatkquiz.quiz.dto;

import java.util.Set;

public record QuestionDto(long id, String questionName, Set<AnswerDto> answers) {
}
