package com.example.spring_bank_project.account.infrastructure.adapter.persistence;

import com.example.spring_bank_project.account.application.useCase.addNewUser.NewUserPersistence;
import com.example.spring_bank_project.account.domain.model.NewUser;
import com.example.spring_bank_project.account.domain.model.StandardAccount;
import com.example.spring_bank_project.account.infrastructure.mapper.AccountMapper;
import com.example.spring_bank_project.account.infrastructure.mapper.UserMapper;
import com.example.spring_bank_project.account.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NewUserPersistenceAdapter implements NewUserPersistence {
    private final UserMapper userMapper;
    private final AccountMapper accountMapper;
    private final UserRepository userRepository;

    @Override
    public void save(NewUser newUser, StandardAccount standardAccount) {
        var account = this.accountMapper.standardAccountToAccount(standardAccount);
        var user = this.userMapper.newUserWithAccountToEntity(newUser, account);

        this.userRepository.save(user);
    }
}
