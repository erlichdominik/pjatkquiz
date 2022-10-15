package com.pjatk.ddd.model;

import java.util.UUID;

public interface AggregateId {
   default UUID generate() {
       return UUID.randomUUID();
   }
}
