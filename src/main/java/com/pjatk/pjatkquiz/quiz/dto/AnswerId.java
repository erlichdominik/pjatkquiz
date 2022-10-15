package com.pjatk.pjatkquiz.quiz.dto;

import com.pjatk.model.DomainId;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Value
@NoArgsConstructor(access = PROTECTED, force = true)
public class AnswerId implements Serializable, DomainId {
    @GeneratedValue
    UUID value;
}