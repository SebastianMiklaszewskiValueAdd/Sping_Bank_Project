package com.example.spring_bank_project.account.infrastructure.mapper;

import com.example.spring_bank_project.account.domain.model.StandardAccount;
import com.example.spring_bank_project.account.infrastructure.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(target = "id", source = "standardAccount.accountId.accountId")
    Account standardAccountToAccount(StandardAccount standardAccount);
}
