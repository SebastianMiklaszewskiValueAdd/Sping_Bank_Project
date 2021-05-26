package com.example.spring_bank_project.account.application.useCase.configureAccountFinances;

import com.example.spring_bank_project.account.domain.factory.FinanceModelFactory;
import com.example.spring_bank_project.account.domain.model.AccountFinances;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfigureAccountFinancesHandler {
    private final FinanceModelFactory factory;
    private final ConfigureAccountFinancesPersistence persistence;

    public void handle(ConfigureAccountFinancesCommand command) {
        var contract = command.getContract();

        var finance = this.createFinance(contract);

        this.persistence.saveFinance(finance);
    }

    private AccountFinances createFinance(ConfigureAccountFinancesContract contract) {
        var accountId = contract.getAccountId();
        var currency = contract.getCurrency();

        var finance = this.factory.createAccountFinanceWithoutDailyPaymentsLimit(accountId, currency);

        if (contract.shouldSetDailyPaymentsLimit()) {
            finance.setDailyPaymentsLimit(contract.getDailyPaymentsLimit());
        }

        return finance;
    }
}
