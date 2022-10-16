package com.pjatk.pjatkquiz.user.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
class WalkthroughSnapshot {
    private long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long quizId;
    private int correctAnswers;
    private int allAnswers;

    WalkthroughSnapshot(long id, LocalDateTime startTime, LocalDateTime endTime, long quizId, int correctAnswers, int allAnswers) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.quizId = quizId;
        this.correctAnswers = correctAnswers;
        this.allAnswers = allAnswers;
    }

    public WalkthroughSnapshot() {}
}
