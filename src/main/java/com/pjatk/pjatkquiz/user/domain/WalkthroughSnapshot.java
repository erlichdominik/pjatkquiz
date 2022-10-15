package com.pjatk.pjatkquiz.user.domain;

import com.pjatk.model.EndTime;
import com.pjatk.model.StartTime;
import com.pjatk.pjatkquiz.quiz.dto.QuizId;
import com.pjatk.pjatkquiz.user.dto.WalkthroughId;
import lombok.Getter;

@Getter
class WalkthroughSnapshot {
    private WalkthroughId id;
    private StartTime startTime;
    private EndTime endTime;
    private QuizId quizId;
    private int correctAnswers;
    private int allAnswers;

    WalkthroughSnapshot(WalkthroughId id, StartTime startTime, EndTime endTime, QuizId quizId, int correctAnswers, int allAnswers) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.quizId = quizId;
        this.correctAnswers = correctAnswers;
        this.allAnswers = allAnswers;
    }

    public WalkthroughSnapshot() {}
}
