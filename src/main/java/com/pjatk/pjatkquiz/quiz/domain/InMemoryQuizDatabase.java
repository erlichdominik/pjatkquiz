package com.pjatk.pjatkquiz.quiz.domain;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryQuizDatabase implements QuizRepository {
    private static final ConcurrentHashMap<Long, Quiz> db = new ConcurrentHashMap<>();
    private static long idCounter = 1L;

    @Override
    public Optional<Quiz> findById(long id) {
        return Optional.of(db.get(id));
    }

    @Override
    public Optional<Quiz> findByQuizName(String quizName) {
        return db.values()
                .stream()
                .filter(it -> it.getSnapshot().getQuizName().equals(quizName))
                .findFirst();
    }

    @Override
    public Quiz save(Quiz quiz) {
        db.put(idCounter, quiz);
        idCounter++;
        return quiz;
    }
}
