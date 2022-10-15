package com.pjatk.pjatkquiz.user.dto;

import com.pjatk.ddd.model.AggregateId;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.UUID;

import static lombok.AccessLevel.PROTECTED;

@Value
@NoArgsConstructor(access = PROTECTED, force = true)
public class UserId implements Serializable, AggregateId {
    UUID value;
}
