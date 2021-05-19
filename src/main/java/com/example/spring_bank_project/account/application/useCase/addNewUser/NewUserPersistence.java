package com.example.spring_bank_project.account.application.useCase.addNewUser;

import com.example.spring_bank_project.account.domain.model.NewUser;
import com.example.spring_bank_project.account.domain.model.StandardAccount;

import javax.transaction.Transactional;

public interface NewUserPersistence {
    @Transactional
    void save(NewUser newUser, StandardAccount standardAccount);
}
