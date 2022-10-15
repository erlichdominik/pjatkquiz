package com.pjatk.pjatkquiz.quiz.domain;

import com.pjatk.model.Name;
import com.pjatk.pjatkquiz.quiz.dto.QuestionId;
import lombok.Getter;

import java.util.Set;

@Getter
class QuestionSnapshot {
    private QuestionId questionId;
    private Name quizName;
    private QuestionSnapshot nextQuestion;
    private Set<AnswerSnapshot> answers;

    QuestionSnapshot(QuestionId questionId, Name quizName, QuestionSnapshot nextQuestion, Set<AnswerSnapshot> answers) {
        this.questionId = questionId;
        this.quizName = quizName;
        this.nextQuestion = nextQuestion;
        this.answers = answers;
    }

    public QuestionSnapshot() {}
}
