package com.example.spring_bank_project.account.infrastructure.adapter.persistence;

import com.example.spring_bank_project.account.application.useCase.addNewUser.NewUserPersistence;
import com.example.spring_bank_project.account.domain.model.NewUser;
import com.example.spring_bank_project.account.infrastructure.mapper.NewUserEntityMapper;
import com.example.spring_bank_project.account.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserPersistence implements NewUserPersistence {
    private final UserRepository repository;
    private final NewUserEntityMapper newUserEntityMapper;

    @Override
    public void save(NewUser newUser) {
        var user = this.newUserEntityMapper.toEntity(newUser);

        this.repository.save(user);
    }
}
