package com.pjatk.pjatkquiz.quiz.domain;

import com.pjatk.pjatkquiz.quiz.command.AddQuestionToQuizCommand;
import com.pjatk.pjatkquiz.quiz.command.CreateQuizCommand;
import com.pjatk.pjatkquiz.quiz.domain.Question.Answer;
import com.pjatk.pjatkquiz.quiz.dto.*;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class QuizFacade {
    private final QuizRepository quizRepository;

    public long createQuiz(CreateQuizCommand command) {
        var quiz = new Quiz(command.quizName());

        return quizRepository.save(quiz).getSnapshot().getId();
    }

    public long addQuestionToQuiz(AddQuestionToQuizCommand command) {

        Quiz managedQuiz = quizRepository.findById(command.quizId()).orElseThrow(() -> new QuizNotFoundException(command.quizId()));

        var question = new Question(command.questionName());

        Set<Answer> answers = command.answers().stream()
                .map(it -> new Answer(it.name(), it.isCorrect()))
                .collect(Collectors.toSet());

        question.addAnswers(answers);
        managedQuiz.addQuestion(question);

        return quizRepository.save(managedQuiz).getSnapshot().getId();
    }


}
