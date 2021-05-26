package com.example.spring_bank_project.auth.application.valueObject;

import com.example.spring_bank_project.shared.domain.valueObject.UserId;
import lombok.Value;

import java.util.UUID;

@Value
public class AuthenticatedUserId {
    UUID id;

    public static AuthenticatedUserId fromUserId(UserId userId) {
        return new AuthenticatedUserId(userId.getUserId());
    }
}
