package com.pjatk.pjatkquiz.quiz.domain;

import com.pjatk.model.Name;
import com.pjatk.pjatkquiz.quiz.dto.QuestionId;
import com.pjatk.pjatkquiz.quiz.dto.QuizId;
import lombok.Getter;

import java.util.Set;

@Getter
class QuizSnapshot {
    private QuizId id;
    private Name quizName;
    private Set<QuestionId> questionIds;

    QuizSnapshot(QuizId id, Name quizName, Set<QuestionId> questionIds) {
        this.id = id;
        this.quizName = quizName;
        this.questionIds = questionIds;
    }

    public QuizSnapshot() {}
}
