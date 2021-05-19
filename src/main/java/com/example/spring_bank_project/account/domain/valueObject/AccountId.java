package com.example.spring_bank_project.account.domain.valueObject;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
public class AccountId {
    private final UUID accountId;

    public AccountId(UUID accountId) {
        this.accountId = accountId;
    }
}
