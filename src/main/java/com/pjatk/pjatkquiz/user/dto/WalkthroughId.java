package com.pjatk.pjatkquiz.user.dto;

import com.pjatk.model.DomainId;

import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.UUID;

public record WalkthroughId(@GeneratedValue UUID value) implements Serializable, DomainId {
}
