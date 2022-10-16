package com.pjatk.pjatkquiz.quiz.domain;


import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface QuestionRepository extends Repository<Question, Long> {
    <S extends Question> S save(S question);

    Optional<Question> findById(long id);

    List<Question> findAll();
}
