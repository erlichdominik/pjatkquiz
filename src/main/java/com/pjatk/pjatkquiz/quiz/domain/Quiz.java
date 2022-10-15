package com.pjatk.pjatkquiz.quiz.domain;

import com.pjatk.ddd.annotations.AggregateRoot;
import com.pjatk.model.Name;
import com.pjatk.pjatkquiz.quiz.dto.QuizId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AggregateRoot
@Entity
class Quiz {
    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private QuizId id;

    @AttributeOverride(name = "value", column = @Column(name = "quiz_name"))
    private Name quizName;

    @OneToMany
    @JoinColumn(name = "question_id")
    private Set<Question> questions = new HashSet<>();
}
