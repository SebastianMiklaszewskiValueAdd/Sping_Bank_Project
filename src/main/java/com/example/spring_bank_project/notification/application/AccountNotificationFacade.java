package com.example.spring_bank_project.notification.application;

import com.example.spring_bank_project.notification.application.useCase.sendAccountWasCreatedNotification.SendAccountWasCreatedNotificationCommand;
import com.example.spring_bank_project.notification.application.useCase.sendAccountWasCreatedNotification.SendAccountWasCreatedNotificationContract;
import com.example.spring_bank_project.notification.application.useCase.sendAccountWasCreatedNotification.SendAccountWasCreatedNotificationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountNotificationFacade {
    private final SendAccountWasCreatedNotificationHandler sendAccountWasCreatedNotificationHandler;

    public void sendAccountCreatedNotification(SendAccountWasCreatedNotificationContract contract) {
        this.sendAccountWasCreatedNotificationHandler.handle(new SendAccountWasCreatedNotificationCommand(contract));
    }
}
