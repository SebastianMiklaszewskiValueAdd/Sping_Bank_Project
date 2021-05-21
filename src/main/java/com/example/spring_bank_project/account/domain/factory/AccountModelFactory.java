package com.example.spring_bank_project.account.domain.factory;

import com.example.spring_bank_project.account.domain.event.AccountEventMapper;
import com.example.spring_bank_project.account.domain.model.NewUser;
import com.example.spring_bank_project.account.domain.model.StandardAccount;
import com.example.spring_bank_project.account.domain.valueObject.AccountId;
import com.example.spring_bank_project.shared.domain.event.EventPublisher;
import com.example.spring_bank_project.shared.domain.factory.UuidFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountModelFactory {
    private final UuidFactory uuidFactory;
    private final AccountEventMapper eventMapper;

    public StandardAccount createBasicStandardAccount(NewUser newUser, EventPublisher publisher) {
        var accountId = new AccountId(this.uuidFactory.newUuid());
        var createdAt = newUser.getCreatedAt();

        var standardAccount = new StandardAccount(accountId, createdAt);

        var event = eventMapper.newUserAndStandardAccountToEvent(this, newUser, standardAccount);
        publisher.publish(event);

        return standardAccount;
    }
}
