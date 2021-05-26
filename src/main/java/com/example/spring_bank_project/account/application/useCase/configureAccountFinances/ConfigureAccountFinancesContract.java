package com.example.spring_bank_project.account.application.useCase.configureAccountFinances;

import com.example.spring_bank_project.account.domain.valueObject.AccountId;
import com.example.spring_bank_project.account.domain.valueObject.Currency;
import com.example.spring_bank_project.account.domain.valueObject.DailyPaymentsLimit;

import java.time.LocalDateTime;

public interface ConfigureAccountFinancesContract {
    AccountId getAccountId();
    DailyPaymentsLimit getDailyPaymentsLimit();
    boolean shouldSetDailyPaymentsLimit();
    Currency getCurrency();
}
