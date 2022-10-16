package com.pjatk.pjatkquiz.user.domain;

import com.pjatk.pjatkquiz.sharedkernel.ddd.annotations.AggregateRoot;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PROTECTED;

@AggregateRoot
@Entity
@NoArgsConstructor(access = PROTECTED)
class ApplicationUser {
    @Id
    @GeneratedValue
    private long id;
    private String email;
    private String password;
    @OneToMany
    @JoinColumn(name = "walkthrough_id")
    private Set<Walkthrough> walkthroughs = new HashSet<>();

    void addWalkthrough(Walkthrough walkthrough) {
        walkthroughs.add(walkthrough);
    }

    void removeWalkthrough(long id) {
        walkthroughs.stream()
                .filter(it -> it.getSnapshot().getId() == id)
                .findFirst()
                .ifPresent(walkthroughs::remove);
    }

    static ApplicationUser restore(UserSnapshot snapshot) {
        return new ApplicationUser(snapshot.getId(), snapshot.getEmail(), snapshot.getPassword(), snapshot.getWalkthroughs()
                .stream()
                .map(Walkthrough::restore)
                .collect(Collectors.toSet()));
    }

    UserSnapshot getSnapshot() {
        return new UserSnapshot(id, email, password, walkthroughs.stream()
                .map(Walkthrough::getSnapshot)
                .collect(Collectors.toSet()));
    }

    private ApplicationUser(long id, String email, String password, Set<Walkthrough> walkthroughs) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.walkthroughs = walkthroughs;
    }

    @Entity
    @NoArgsConstructor(access = PROTECTED)
    static class Walkthrough {
        @Id
        @GeneratedValue
        private long id;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private long quizId;
        private int correctAnswers;
        private int allAnswers;

        static Walkthrough restore(WalkthroughSnapshot snapshot) {
            return new Walkthrough(snapshot.getId(), snapshot.getStartTime(), snapshot.getEndTime(), snapshot.getQuizId(), snapshot.getCorrectAnswers(), snapshot.getAllAnswers());
        }

        WalkthroughSnapshot getSnapshot() {
            return new WalkthroughSnapshot(id, startTime, endTime, quizId, correctAnswers, allAnswers);
        }

        private Walkthrough(long id, LocalDateTime startTime, LocalDateTime endTime, long quizId, int correctAnswers, int allAnswers) {
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
            this.quizId = quizId;
            this.correctAnswers = correctAnswers;
            this.allAnswers = allAnswers;
        }
    }
}
