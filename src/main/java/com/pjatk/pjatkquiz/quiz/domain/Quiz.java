package com.pjatk.pjatkquiz.quiz.domain;

import com.pjatk.pjatkquiz.sharedkernel.ddd.annotations.AggregateRoot;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AggregateRoot
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
class Quiz {
    @Id
    @GeneratedValue
    private long id;
    private String quizName;

    @Size(min = 1, max = 10)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "question_id")
    private Set<Question> questions = new HashSet<>();

    static Quiz restore(QuizSnapshot quizSnapshot) {
        return new Quiz(quizSnapshot.getId(), quizSnapshot.getQuizName(), quizSnapshot.getQuestions()
                .stream().map(Question::restore).collect(Collectors.toSet()));
    }

    void addQuestion(Question question) {
        this.questions.add(question);
    }

    QuizSnapshot getSnapshot() {
        return new QuizSnapshot(id, quizName, questions.stream().map(Question::getSnapshot)
                .collect(Collectors.toSet()));
    }

    public Quiz(String quizName) {
        this.quizName = quizName;
    }

    Quiz(long id, String quizName, Set<Question> questions) {
        this.id = id;
        this.quizName = quizName;
        this.questions = questions;
    }
}
