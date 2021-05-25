package com.example.spring_bank_project.notification.application.useCase.sendAccountWasCreatedNotification;

import com.example.spring_bank_project.notification.domain.valueObject.Contact;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AccountWasCreatedNotificationFactory {
    public AccountWasCreatedEmailNotification create(String recipientFullName, String accountType, Instant createdAt,
            Contact contact) {
        var message = this.createMessage(recipientFullName, accountType, createdAt);

        return new AccountWasCreatedEmailNotification(message, contact);
    }

    private String createMessage(String recipientFullName, String accountType, Instant createdAt) {
        return String.format("Hello, %s! Your %s account was created at %s",
                recipientFullName,
                accountType,
                createdAt.toString());
    }
}
