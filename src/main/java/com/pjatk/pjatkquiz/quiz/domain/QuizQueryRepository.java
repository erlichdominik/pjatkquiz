package com.pjatk.pjatkquiz.quiz.domain;

import com.pjatk.pjatkquiz.quiz.dto.*;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class QuizQueryRepository {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    // quiz should have 10 questions this number should be modifiable
    public QuizDto fetchQuiz(long quizId) {
        //for now, we have one quiz with id 1
        return mapQuizToDto(quizRepository.findById(quizId)
                .orElseThrow(() -> new QuizNotFoundException(quizId)));
    }

    public QuizDto fetchQuizByQuizName(String quizName) {
        return mapQuizToDto(quizRepository.findByQuizName(quizName)
                .orElseThrow(() -> new QuizNotFoundException(quizName)));
    }

    public QuestionDto startQuiz() {
        return mapQuestionToDto(questionRepository
                .findAll()
                .stream()
                .findFirst()
                .orElseThrow(QuestionNotFoundException::new));
    }

    public QuestionDto fetchQuestion(long questionId) {
        return questionRepository
                .findById(questionId)
                .map(this::mapQuestionToDto)
                .orElseThrow(() -> new QuestionNotFoundException(questionId));
    }

    public QuestionDto fetchNextQuestion(long currentQuestionId) {
        return mapQuestionToDto(questionRepository.findById(currentQuestionId+1)
                .orElseThrow(() -> new QuestionNotFoundException(currentQuestionId+1)));
    }

    private QuizDto mapQuizToDto(Quiz quiz) {
        QuizSnapshot snapshot = quiz.getSnapshot();

        return new QuizDto(snapshot.getId(), snapshot.getQuizName(),
                snapshot.getQuestions().stream().map(Question::restore)
                        .map(this::mapQuestionToDto).collect(Collectors.toSet())
        );
    }

    private QuestionDto mapQuestionToDto(Question question) {
        QuestionSnapshot questionSnapshot = question.getSnapshot();

        return new QuestionDto(questionSnapshot.getQuestionId(), questionSnapshot.getQuizName(), questionSnapshot.getAnswers().stream().map(this::mapAnswerToDto)
                .collect(Collectors.toSet()));
    }

    private AnswerDto mapAnswerToDto(AnswerSnapshot snapshot) {
        return new AnswerDto(snapshot.getName(), snapshot.isCorrect());
    }
}
