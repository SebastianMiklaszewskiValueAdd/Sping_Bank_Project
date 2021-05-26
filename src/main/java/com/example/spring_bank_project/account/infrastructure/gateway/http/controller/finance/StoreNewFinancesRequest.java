package com.example.spring_bank_project.account.infrastructure.gateway.http.controller.finance;

import com.example.spring_bank_project.account.application.useCase.configureAccountFinances.ConfigureAccountFinancesContract;
import com.example.spring_bank_project.account.domain.valueObject.AccountId;
import com.example.spring_bank_project.account.domain.valueObject.Currency;
import com.example.spring_bank_project.account.domain.valueObject.DailyPaymentsLimit;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Embedded;

@Data
class StoreNewFinancesRequest implements ConfigureAccountFinancesContract {
    private AccountId accountId;
    @Embedded.Nullable
    private DailyPaymentsLimit dailyPaymentsLimit;
    private Currency currency;

    public boolean shouldSetDailyPaymentsLimit() {
        return this.dailyPaymentsLimit == null;
    }
}
