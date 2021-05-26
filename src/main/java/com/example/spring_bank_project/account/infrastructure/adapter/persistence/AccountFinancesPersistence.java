package com.example.spring_bank_project.account.infrastructure.adapter.persistence;

import com.example.spring_bank_project.account.application.useCase.configureAccountFinances.ConfigureAccountFinancesPersistence;
import com.example.spring_bank_project.account.domain.model.AccountFinances;
import com.example.spring_bank_project.account.domain.valueObject.AccountId;
import com.example.spring_bank_project.account.infrastructure.entity.Account;
import com.example.spring_bank_project.account.infrastructure.mapper.AccountFinanceMapper;
import com.example.spring_bank_project.account.infrastructure.repository.AccountRepository;
import com.example.spring_bank_project.account.infrastructure.repository.FinanceRepository;
import com.example.spring_bank_project.shared.application.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AccountFinancesPersistence implements ConfigureAccountFinancesPersistence {
    private final AccountRepository accountRepository;
    private final AccountFinanceMapper mapper;
    private final FinanceRepository financeRepository;

    @Override
    public void saveFinance(AccountFinances finance) {
        var account = this.findAccount(finance.getAccountId());

        var financeEntity = mapper.modelAndAccountToEntity(finance, account);

        this.financeRepository.save(financeEntity);
    }

    private Account findAccount(AccountId accountId) {
        var account = this.accountRepository.findById(accountId.getAccountId());

        return account.orElseThrow(() -> new NotFoundException(String.format("Account: %s not found.",
                accountId.getAccountId())));
    }

}
