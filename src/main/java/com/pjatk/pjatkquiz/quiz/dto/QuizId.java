package com.pjatk.pjatkquiz.quiz.dto;

import com.pjatk.pjatkquiz.sharedkernel.ddd.model.AggregateId;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;

import static lombok.AccessLevel.PROTECTED;

@Value
@NoArgsConstructor(access = PROTECTED, force = true)
@RequiredArgsConstructor(staticName = "of")
public class QuizId implements Serializable, AggregateId {
    long value;
}
