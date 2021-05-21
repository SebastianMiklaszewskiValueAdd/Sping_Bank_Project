package com.example.spring_bank_project.account.application.useCase.addNewUser;

import com.example.spring_bank_project.account.domain.exception.InvalidPinException;
import com.example.spring_bank_project.account.domain.exception.UserIsNotAdultException;
import com.example.spring_bank_project.account.domain.factory.AccountModelFactory;
import com.example.spring_bank_project.account.domain.factory.UserModelFactory;
import com.example.spring_bank_project.shared.application.exception.BrokenContractException;
import com.example.spring_bank_project.shared.domain.event.EventPublisher;
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
    private final EventPublisher publisher;

    public void handle(AddNewUserCommand command) {
        var contract = command.getContract();

        this.validateData(contract);

        var encodedPin = this.encoder.encode(contract.getPin());

        var newUser = this.userModelFactory.createNewUser(contract.getId(),
                contract.getFirstName(),
                contract.getLastName(),
                contract.getBirthDate(),
                contract.getEmail(),
                encodedPin,
                contract.getCreatedAt());
        var standardAccount = this.accountModelFactory.createBasicStandardAccount(newUser, this.publisher);

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
