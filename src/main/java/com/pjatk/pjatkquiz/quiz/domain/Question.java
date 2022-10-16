package com.pjatk.pjatkquiz.quiz.domain;

import com.pjatk.pjatkquiz.sharedkernel.ddd.annotations.AggregateRoot;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PROTECTED;

@AggregateRoot
@Entity
@NoArgsConstructor(access = PROTECTED)
class Question {
    @Id
    @GeneratedValue
    private long id;
    private String questionName;
    @OneToMany
    @JoinColumn(name = "answer_id")
    private Set<Answer> answers = new HashSet<>();

    static Question restore(QuestionSnapshot snapshot) {
        return new Question(snapshot.getQuestionId(), snapshot.getQuizName(),
                snapshot.getAnswers()
                        .stream()
                        .map(Answer::restore)
                        .collect(Collectors.toSet()));
    }

    QuestionSnapshot getSnapshot() {
        return new QuestionSnapshot(id, questionName, answers
                .stream()
                .map(Answer::getSnapshot)
                .collect(Collectors.toSet()));
    }

    Question(long id, String questionName, Set<Answer> answers) {
        this.id = id;
        this.questionName = questionName;
        this.answers = answers;
    }

    public Question(String questionName) {
        this.questionName = questionName;
    }

    void addAnswers(Collection<Answer> answers) {
        this.answers.addAll(answers);
    }

    @Entity
    @NoArgsConstructor(access = PROTECTED)
    static class Answer {
        @Id
        @GeneratedValue
        private long id;
        private String name;
        private boolean isCorrect;

        static Answer restore(AnswerSnapshot snapshot) {
            return new Answer(snapshot.getId(), snapshot.getName(), snapshot.isCorrect());
        }

        AnswerSnapshot getSnapshot() {
            return new AnswerSnapshot(id, name, isCorrect);
        }

        private Answer(long id, String name, boolean isCorrect) {
            this.id = id;
            this.name = name;
            this.isCorrect = isCorrect;
        }

        public Answer(String name, boolean isCorrect) {
            this.name = name;
            this.isCorrect = isCorrect;
        }
    }
}
