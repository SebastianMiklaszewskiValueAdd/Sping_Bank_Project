package com.example.spring_bank_project.account.domain.notification;

import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
class AccountWasCreatedSuccessfullyNotification {
    private final Instant createdAt;
}
