package com.pjatk.pjatkquiz.user.domain;

import com.pjatk.ddd.annotations.AggregateRoot;
import com.pjatk.model.Email;
import com.pjatk.model.EndTime;
import com.pjatk.model.Password;
import com.pjatk.model.StartTime;
import com.pjatk.pjatkquiz.infrastructure.AbstractBaseEntity;
import com.pjatk.pjatkquiz.quiz.dto.QuizId;
import com.pjatk.pjatkquiz.user.dto.UserId;
import com.pjatk.pjatkquiz.user.dto.WalkthroughId;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PROTECTED;

@AggregateRoot
@Entity
@NoArgsConstructor(access = PROTECTED)
class User extends AbstractBaseEntity {
    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private UserId id;

    @AttributeOverride(name = "value", column = @Column(name = "email"))
    private Email email;

    @AttributeOverride(name = "value", column = @Column(name = "password"))
    private Password password;
    @OneToMany
    @JoinColumn(name = "walkthroughId")

    private Set<Walkthrough> walkthroughs = new HashSet<>();

    void addWalkthrough(Walkthrough walkthrough) {
        walkthroughs.add(walkthrough);
    }

    void removeWalkthrough(WalkthroughId id) {
        walkthroughs.stream()
                .filter(it -> it.getSnapshot().getId().equals(id))
                .findFirst()
                .ifPresent(walkthroughs::remove);
    }

    static User restore(UserSnapshot snapshot) {
        return new User(snapshot.getId(), snapshot.getEmail(), snapshot.getPassword(), snapshot.getWalkthroughs()
                .stream()
                .map(Walkthrough::restore)
                .collect(Collectors.toSet()));
    }

    UserSnapshot getSnapshot() {
        return new UserSnapshot(id, email, password, walkthroughs.stream()
                .map(Walkthrough::getSnapshot)
                .collect(Collectors.toSet()));
    }

    private User(UserId id, Email email, Password password, Set<Walkthrough> walkthroughs) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.walkthroughs = walkthroughs;
    }

    @Entity
    @NoArgsConstructor(access = PROTECTED)
    static class Walkthrough extends AbstractBaseEntity {
        @EmbeddedId
        @AttributeOverride(name = "value", column = @Column(name = "id"))
        private WalkthroughId id;

        @AttributeOverride(name = "value", column = @Column(name = "start_time"))
        private StartTime startTime;

        @AttributeOverride(name = "value", column = @Column(name = "end_time"))
        private EndTime endTime;

        @AttributeOverride(name = "value", column = @Column(name = "quiz_id"))
        private QuizId quizId;
        private int correctAnswers;
        private int allAnswers;

        static Walkthrough restore(WalkthroughSnapshot snapshot) {
            return new Walkthrough(snapshot.getId(), snapshot.getStartTime(), snapshot.getEndTime(), snapshot.getQuizId(), snapshot.getCorrectAnswers(), snapshot.getAllAnswers());
        }

        WalkthroughSnapshot getSnapshot() {
            return new WalkthroughSnapshot(id, startTime, endTime, quizId, correctAnswers, allAnswers);
        }

        private Walkthrough(WalkthroughId id, StartTime startTime, EndTime endTime, QuizId quizId, int correctAnswers, int allAnswers) {
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
            this.quizId = quizId;
            this.correctAnswers = correctAnswers;
            this.allAnswers = allAnswers;
        }
    }
}
