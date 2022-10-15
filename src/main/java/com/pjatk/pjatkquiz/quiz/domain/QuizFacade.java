package com.pjatk.pjatkquiz.quiz.domain;

import com.pjatk.pjatkquiz.quiz.dto.AnswerDto;
import com.pjatk.pjatkquiz.quiz.dto.QuestionDto;
import com.pjatk.pjatkquiz.quiz.dto.QuestionId;
import com.pjatk.pjatkquiz.quiz.dto.QuestionNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class QuizFacade {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuestionDto fetchQuestion(QuestionId questionId) {
        return questionRepository
                .findById(questionId)
                .map(this::mapQuestionToDto)
                .orElseThrow(() -> new QuestionNotFoundException(questionId));
    }

    public QuestionDto fetchNextQuestion(QuestionId currentQuestionId) {
        QuestionSnapshot questionSnapshot = questionRepository
                .findById(currentQuestionId)
                .map(Question::getSnapshot)
                .orElseThrow(() -> new QuestionNotFoundException(currentQuestionId));

        return questionRepository
                .findById(questionSnapshot.getNextQuestion().getQuestionId())
                .map(this::mapQuestionToDto)
                .orElseThrow(() -> new QuestionNotFoundException(questionSnapshot.getNextQuestion().getQuestionId()));
    }


    private QuestionDto mapQuestionToDto(Question question) {
        QuestionSnapshot questionSnapshot = question.getSnapshot();

        return new QuestionDto(questionSnapshot.getQuestionId(), questionSnapshot.getQuizName(), questionSnapshot.getAnswers().stream().map(this::mapAnswerToDto)
                .collect(Collectors.toSet()));
    }

    private AnswerDto mapAnswerToDto(AnswerSnapshot snapshot) {

        return new AnswerDto(snapshot.getId(), snapshot.getName(), snapshot.getIsCorrect());
    }

}
