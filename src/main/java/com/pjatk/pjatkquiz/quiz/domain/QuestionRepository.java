package com.pjatk.pjatkquiz.quiz.domain;


import com.pjatk.model.Name;
import com.pjatk.pjatkquiz.quiz.dto.QuestionId;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

interface QuestionRepository extends Repository<Question, UUID> {
    <S extends Question> S save(S question);

    Optional<Question> findById(QuestionId id);

    List<Question> findAllByQuizName(Name name);
}
