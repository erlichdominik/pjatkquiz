package com.pjatk.pjatkquiz.quiz.dto;

import com.pjatk.ddd.model.AggregateId;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Value
@NoArgsConstructor(access = PRIVATE, force = true)
public class QuestionId implements Serializable, AggregateId {
    UUID value;
}
