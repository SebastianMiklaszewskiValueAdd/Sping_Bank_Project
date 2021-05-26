package com.example.spring_bank_project.account.domain.valueObject;

import lombok.Value;

import java.util.UUID;

@Value
public class AccountId {
    UUID accountId;

    public AccountId(String accountId) {
        this.accountId = UUID.fromString(accountId);
    }

    public AccountId(UUID accountId) {
        this.accountId = accountId;
    }
}
