package com.pjatk.pjatkquiz.quiz.dto;

import com.pjatk.model.IsCorrect;
import com.pjatk.model.Name;

public record AnswerDto(AnswerId id, Name name, IsCorrect isCorrect) {
}
