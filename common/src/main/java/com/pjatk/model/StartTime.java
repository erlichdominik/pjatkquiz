package com.pjatk.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public record StartTime(LocalDateTime value) implements Serializable {
}
