package com.example.spring_bank_project.shared.domain.event;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.Instant;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Value
public class AccountWasCreated extends Event {
    Instant createdAt;
    String accountType;
    String email;
    String userFullName;

    public AccountWasCreated(Object source,
            Instant createdAt,
            String accountType,
            String email, String userFullName) {
        super(source);
        this.createdAt = createdAt;
        this.accountType = accountType;
        this.email = email;
        this.userFullName = userFullName;
    }
}
