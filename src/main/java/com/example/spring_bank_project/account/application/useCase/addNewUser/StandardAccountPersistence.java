package com.example.spring_bank_project.account.application.useCase.addNewUser;

import com.example.spring_bank_project.account.domain.model.StandardAccount;

public interface StandardAccountPersistence {
    void save(StandardAccount standardAccount);
}
