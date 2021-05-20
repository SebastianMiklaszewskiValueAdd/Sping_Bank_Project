package com.example.spring_bank_project.account.application.useCase.addNewUser;

import com.example.spring_bank_project.account.domain.exception.InvalidPinException;
import com.example.spring_bank_project.account.domain.exception.UserIsNotAdultException;
import com.example.spring_bank_project.account.domain.factory.UserModelFactory;
import com.example.spring_bank_project.shared.application.exception.BrokenContractException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class AddNewUserHandler {
    private final UserModelFactory factory;
    private final NewUserPersistence persistence;
    private final PinEncoder encoder;
    private final AddNewUserCommandDataValidator dataValidator;

    public void handle(AddNewUserCommand command) {
        var contract = command.getContract();

        this.validateData(contract);

        var encodedPin = this.encoder.encode(contract.getPin());

        var newUser = this.factory.createNewUser(contract.getId(), contract.getFirstName(), contract.getLastName(),
                contract.getBirthDate(), contract.getEmail(), encodedPin);

        this.persistence.save(newUser);

        // TODO: add event UserCreated to create account for user in next pr
        // TODO: add tests for this feature in next pr
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
