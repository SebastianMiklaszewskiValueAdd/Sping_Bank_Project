package com.example.spring_bank_project.account.infrastructure.adapter.dpi;

import com.example.spring_bank_project.account.application.dpi.UserAuthDpiServiceInterface;
import com.example.spring_bank_project.account.application.useCase.addNewUser.PinEncoder;
import com.example.spring_bank_project.account.infrastructure.entity.User;
import com.example.spring_bank_project.account.infrastructure.repository.UserRepository;
import com.example.spring_bank_project.shared.application.exception.InvalidCredentialsException;
import com.example.spring_bank_project.shared.application.exception.NotFoundException;
import com.example.spring_bank_project.shared.domain.valueObject.Email;
import com.example.spring_bank_project.shared.domain.valueObject.Pin;
import com.example.spring_bank_project.shared.domain.valueObject.UserId;
import com.example.spring_bank_project.shared.infrastructure.auth.UserSecurityData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthDpiService implements UserAuthDpiServiceInterface {
    private final UserRepository userRepository;
    private final PinEncoder pinEncoder;

    @Override
    public UserId fetchUserIdFromUserByEmailIfPinIsCorrect(Email email, Pin pin) {
        var user = this.userRepository.findByEmail(email.getEmail());

        if (!user.map(presentUser -> presentUser.isPinMatches(pin, this.pinEncoder)).orElseThrow()) {
            throw new InvalidCredentialsException();
        }

        return user.get().getUserId();
    }

    @Override
    public UserSecurityData fetchUserSecurityDataOrFail(UserId userId) {
        var user = this.userRepository.findById(userId.getUserId());

        return user.map(User::getUserSecurityData)
                   .orElseThrow(() -> new NotFoundException(String.format("User: %s " + "not found",
                           userId.getUserId())));
    }
}
