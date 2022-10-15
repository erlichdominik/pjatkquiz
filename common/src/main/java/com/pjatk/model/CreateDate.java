package com.pjatk.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public record CreateDate(LocalDateTime value) implements Serializable {
}
