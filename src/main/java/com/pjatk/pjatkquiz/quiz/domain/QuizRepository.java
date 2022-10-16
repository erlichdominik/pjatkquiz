package com.pjatk.pjatkquiz.quiz.domain;

import org.springframework.data.repository.Repository;

import java.util.Optional;

interface QuizRepository extends Repository<Quiz, Long> {
    Optional<Quiz> findById(long id);
    Optional<Quiz> findByQuizName(String quizName);
    Quiz save(Quiz quiz);
}
