package com.example.spring_bank_project.account.application.useCase.addNewUser;

import com.example.spring_bank_project.account.domain.exception.InvalidPinException;
import com.example.spring_bank_project.account.domain.exception.UserIsNotAdultException;
import com.example.spring_bank_project.account.domain.factory.AccountModelFactory;
import com.example.spring_bank_project.account.domain.factory.UserModelFactory;
import com.example.spring_bank_project.shared.application.exception.BrokenContractException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class AddNewUserHandler {
    private final UserModelFactory userModelFactory;
    private final AccountModelFactory accountModelFactory;
    private final AddNewUserCommandDataValidator dataValidator;
    private final PinEncoder encoder;
    private final NewUserPersistence persistence;

    public void handle(AddNewUserCommand command) {
        var contract = command.getContract();

        this.validateData(contract);

        var encodedPin = this.encoder.encode(contract.getPin());
        var createdAt = contract.getCreatedAt();

        var newUser = this.userModelFactory.createNewUser(contract.getId(),
                contract.getFirstName(),
                contract.getLastName(),
                contract.getBirthDate(),
                contract.getEmail(),
                encodedPin,
                createdAt);
        var standardAccount = this.accountModelFactory.createBasicStandardAccount(createdAt);

        this.persistence.save(newUser, standardAccount);
    }

    private void validateData(AddNewUserContract contract) {
        try {
            this.dataValidator.assertUserIsAdult(contract.getBirthDate(), LocalDate.now());
            this.dataValidator.assertPinIsCorrect(contract.getPin());
        } catch (UserIsNotAdultException | InvalidPinException e) {
            throw new BrokenContractException(e.getMessage());
        }
    }
}
