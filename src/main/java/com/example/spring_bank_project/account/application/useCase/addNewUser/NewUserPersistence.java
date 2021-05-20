package com.example.spring_bank_project.account.application.useCase.addNewUser;

import com.example.spring_bank_project.account.domain.model.NewUser;

import javax.transaction.Transactional;

public interface NewUserPersistence {
    @Transactional
    void save(NewUser newUser);
}
