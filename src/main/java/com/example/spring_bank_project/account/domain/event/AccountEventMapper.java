package com.example.spring_bank_project.account.domain.event;

import com.example.spring_bank_project.account.domain.factory.AccountModelFactory;
import com.example.spring_bank_project.account.domain.model.NewUser;
import com.example.spring_bank_project.account.domain.model.StandardAccount;
import com.example.spring_bank_project.account.domain.valueObject.FirstName;
import com.example.spring_bank_project.account.domain.valueObject.LastName;
import com.example.spring_bank_project.shared.domain.event.AccountWasCreated;
import lombok.EqualsAndHashCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AccountModelFactory.class})
public interface AccountEventMapper {

    @Mapping(target = "createdAt", source = "standardAccount.createdAt")
    @Mapping(target = "accountType", expression = "java(standardAccount.getType().toString())")
    @Mapping(target = "email", source = "newUser.email.email")
    @Mapping(target = "userFullName", expression = "java(this.firstNameAndLastNameToFullName(newUser.getFirstName(), newUser.getLastName()))")
    AccountWasCreated newUserAndStandardAccountToEvent(Object source, NewUser newUser, StandardAccount standardAccount);

    default String firstNameAndLastNameToFullName(FirstName firstName, LastName lastName) {
        return String.join(" ", firstName.getFirstName(), lastName.getLastName());
    }
}
