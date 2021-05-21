package com.example.spring_bank_project.notification.application.useCase.sendAccountWasCreatedNotification;

import com.example.spring_bank_project.notification.domain.valueObject.Contact;

import java.time.Instant;

public interface SendAccountWasCreatedNotificationContract {
    Contact getContact();
    Instant getCreatedAt();
    String getAccountType();
    String getRecipientFullName();
}
