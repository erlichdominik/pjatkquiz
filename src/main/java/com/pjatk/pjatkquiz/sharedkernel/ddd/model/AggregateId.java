package com.pjatk.pjatkquiz.sharedkernel.ddd.model;

import java.util.UUID;

public interface AggregateId {
   default UUID generate() {
       return UUID.randomUUID();
   }
}
