package com.example.spring_bank_project.account.infrastructure.mapper;

import com.example.spring_bank_project.account.domain.model.NewUser;
import com.example.spring_bank_project.account.infrastructure.entity.Account;
import com.example.spring_bank_project.account.infrastructure.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", source = "newUser.userId.userId")
    @Mapping(target = "firstName", source = "newUser.firstName.firstName")
    @Mapping(target = "lastName", source = "newUser.lastName.lastName")
    @Mapping(target = "birthDate", source = "newUser.birthDate.birthDate")
    @Mapping(target = "email", source = "newUser.email.email")
    @Mapping(target = "pin", source = "newUser.pin.encodedPin")
    @Mapping(target = "accounts", expression = "java(this.standardAccountToNewSetWithRelation(account, user))")
    User newUserWithAccountToEntity(NewUser newUser, Account account);

    default Set<Account> standardAccountToNewSetWithRelation(Account account, User user) {
        account.setOwner(user);
        return Set.of(account);
    }
}
