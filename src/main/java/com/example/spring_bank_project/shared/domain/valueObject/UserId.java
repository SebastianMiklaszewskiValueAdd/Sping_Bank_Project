package com.example.spring_bank_project.shared.domain.valueObject;

import lombok.Value;

import java.util.UUID;

@Value
public class UserId {
    UUID userId;

    public UserId(String userId) {
        this.userId = UUID.fromString(userId);
    }

    public UserId(UUID userId) {
        this.userId = userId;
    }
}
