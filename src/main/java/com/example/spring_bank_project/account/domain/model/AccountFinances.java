package com.example.spring_bank_project.account.domain.model;

import com.example.spring_bank_project.account.domain.valueObject.AccountId;
import com.example.spring_bank_project.account.domain.valueObject.Currency;
import com.example.spring_bank_project.account.domain.valueObject.DailyPaymentsLimit;
import com.example.spring_bank_project.account.domain.valueObject.FinanceId;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Embedded;

@Data
public class AccountFinances {
    private final FinanceId financeId;
    private final AccountId accountId;
    private final Currency currency;
    @Embedded.Nullable
    private DailyPaymentsLimit dailyPaymentsLimit;

    public boolean hasLimit() {
        return this.dailyPaymentsLimit != null;
    }
}
