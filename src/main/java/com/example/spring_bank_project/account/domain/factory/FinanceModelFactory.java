package com.example.spring_bank_project.account.domain.factory;

import com.example.spring_bank_project.account.domain.model.AccountFinances;
import com.example.spring_bank_project.account.domain.valueObject.AccountId;
import com.example.spring_bank_project.account.domain.valueObject.Currency;
import com.example.spring_bank_project.account.domain.valueObject.FinanceId;
import com.example.spring_bank_project.shared.domain.factory.UuidFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinanceModelFactory {
    private final UuidFactory uuidFactory;

    public AccountFinances createAccountFinanceWithoutDailyPaymentsLimit(
            AccountId accountId,
            Currency currency) {
        return new AccountFinances(new FinanceId(this.uuidFactory.newUuid()), accountId, currency);
    }
}
