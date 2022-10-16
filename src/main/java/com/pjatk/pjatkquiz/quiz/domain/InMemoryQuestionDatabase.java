package com.pjatk.pjatkquiz.quiz.domain;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

class InMemoryQuestionDatabase implements QuestionRepository{
    private ConcurrentHashMap<Long, Question> db = new ConcurrentHashMap<>();

    @Override
    public <S extends Question> S save(S question) {
        requireNonNull(question);
        db.put(question.getSnapshot().getQuestionId(), question);
        return question;
    }

    @Override
    public Optional<Question> findById(long id) {
        return Optional.of(db.get(id));
    }

    @Override
    public List<Question> findAll() {
        return db.values().stream().toList();
    }
}
