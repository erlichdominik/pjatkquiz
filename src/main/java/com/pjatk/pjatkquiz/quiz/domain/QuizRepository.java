package com.pjatk.pjatkquiz.quiz.domain;

import com.pjatk.pjatkquiz.quiz.dto.QuizId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

interface QuizRepository extends JpaRepository<Quiz, UUID> {
    Optional<Quiz> findById(QuizId id);
}
