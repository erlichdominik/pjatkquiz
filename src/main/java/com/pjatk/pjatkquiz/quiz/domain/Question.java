package com.pjatk.pjatkquiz.quiz.domain;

import com.pjatk.ddd.annotations.AggregateRoot;
import com.pjatk.model.IsCorrect;
import com.pjatk.model.Name;
import com.pjatk.pjatkquiz.quiz.dto.AnswerId;
import com.pjatk.pjatkquiz.quiz.dto.QuestionId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PROTECTED;

@AggregateRoot
@Entity
@NoArgsConstructor(access = PROTECTED)
class Question {
    @Getter
    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private QuestionId id;

    @AttributeOverride(name = "value", column = @Column(name = "quiz_name"))
    private Name quizName;

    @OneToOne
    @JoinColumn(name = "next_question_id")
    private Question nextQuestion;

    @OneToMany
    @JoinColumn(name = "answer_id")
    private Set<Answer> answers;

    static Question restore(QuestionSnapshot snapshot) {
        return new Question(snapshot.getQuestionId(), snapshot.getQuizName(), Question.restore(snapshot.getNextQuestion()),
                snapshot.getAnswers()
                        .stream()
                        .map(Answer::restore)
                        .collect(Collectors.toSet()));
    }

    QuestionSnapshot getSnapshot() {
        return new QuestionSnapshot(id, quizName, nextQuestion.getSnapshot(), answers
                .stream()
                .map(Answer::getSnapshot)
                .collect(Collectors.toSet()));
    }

    Question(QuestionId id, Name quizName, Question nextQuestion, Set<Answer> answers) {
        this.id = id;
        this.quizName = quizName;
        this.nextQuestion = nextQuestion;
        this.answers = answers;
    }

    @Entity
    @NoArgsConstructor(access = PROTECTED)
    static class Answer {
        @Getter
        @AttributeOverride(name = "value", column = @Column(name = "id"))
        @EmbeddedId
        private AnswerId id;

        @AttributeOverride(name = "value", column = @Column(name = "name"))
        private Name name;

        @AttributeOverride(name = "value", column = @Column(name = "is_correct"))
        private IsCorrect isCorrect;

        static Answer restore(AnswerSnapshot snapshot) {
            return new Answer(snapshot.getId(), snapshot.getName(), snapshot.getIsCorrect());
        }

        AnswerSnapshot getSnapshot() {
            return new AnswerSnapshot(id, name, isCorrect);
        }

        private Answer(AnswerId id, Name name, IsCorrect isCorrect) {
            this.id = id;
            this.name = name;
            this.isCorrect = isCorrect;
        }
    }
}
