package com.example.spring_bank_project.account.infrastructure.mapper;

import com.example.spring_bank_project.account.domain.model.AccountFinances;
import com.example.spring_bank_project.account.infrastructure.entity.Account;
import com.example.spring_bank_project.account.infrastructure.entity.Finance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountFinanceMapper {
    @Mapping(target = "money", ignore = true)
    @Mapping(target = "id", source = "model.financeId.id")
    @Mapping(target = "dailyPaymentsLimit", source = "model.dailyPaymentsLimit.limit")
    Finance modelAndAccountToEntity(AccountFinances model, Account account);
}
