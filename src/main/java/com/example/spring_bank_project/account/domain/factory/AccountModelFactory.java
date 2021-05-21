package com.example.spring_bank_project.account.domain.factory;

import com.example.spring_bank_project.account.domain.model.StandardAccount;
import com.example.spring_bank_project.account.domain.valueObject.AccountId;
import com.example.spring_bank_project.shared.domain.factory.UuidFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class AccountModelFactory {
    private final UuidFactory uuidFactory;

    public StandardAccount createBasicStandardAccount(Instant createdAt) {
        return new StandardAccount(new AccountId(this.uuidFactory.newUuid()), createdAt);
    }
}
