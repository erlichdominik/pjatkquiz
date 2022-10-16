package com.pjatk.pjatkquiz.quiz.command;

import com.pjatk.pjatkquiz.quiz.dto.AnswerDto;

import java.util.List;

public record AddQuestionToQuizCommand(long quizId, String questionName, List<AnswerDto> answers) {
}
