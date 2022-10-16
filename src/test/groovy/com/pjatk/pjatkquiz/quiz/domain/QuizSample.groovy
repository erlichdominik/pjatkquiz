package com.pjatk.pjatkquiz.quiz.domain

import com.pjatk.pjatkquiz.quiz.command.AddQuestionToQuizCommand
import com.pjatk.pjatkquiz.quiz.command.CreateQuizCommand
import com.pjatk.pjatkquiz.quiz.dto.AnswerDto

trait QuizSample {
    CreateQuizCommand createQuizCommand = new CreateQuizCommand('quiz')

    List<AnswerDto> answerDtos = new ArrayList<>(List.of(
            new AnswerDto('answer1', true),
            new AnswerDto('answer2', false),
            new AnswerDto('answer3', false),
            new AnswerDto('answer4', false),
    ))

    AddQuestionToQuizCommand addQuestionToQuizCommand = new AddQuestionToQuizCommand(1L, 'question1', answerDtos)
}