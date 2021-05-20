package com.example.spring_bank_project.account.infrastructure.mapper;

import com.example.spring_bank_project.account.domain.model.NewUser;
import com.example.spring_bank_project.account.infrastructure.entity.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NewUserEntityMapper {
    public User toEntity(NewUser newUser) {
        return new User(UUID.fromString(newUser.getUserId().getUserId()), newUser.getFirstName().getFirstName(),
                newUser.getLastName().getLastName(), newUser.getBirthDate().getBirthDate(),
                newUser.getEmail().getEmail(), newUser.getPin().getEncodedPin());
    }
}
