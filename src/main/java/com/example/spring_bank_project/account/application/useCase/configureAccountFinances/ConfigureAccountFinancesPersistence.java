package com.example.spring_bank_project.account.application.useCase.configureAccountFinances;

import com.example.spring_bank_project.account.domain.model.AccountFinances;

public interface ConfigureAccountFinancesPersistence {
    void saveFinance(AccountFinances finances);
}
