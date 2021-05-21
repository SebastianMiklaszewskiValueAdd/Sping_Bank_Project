package com.example.spring_bank_project.account.domain.model;

import com.example.spring_bank_project.account.domain.valueObject.AccountId;
import com.example.spring_bank_project.account.domain.valueObject.AccountType;
import lombok.Value;

import java.time.Instant;

@Value
public class StandardAccount {
    AccountId accountId;
    AccountType type = AccountType.STANDARD;
    Instant createdAt;
}
