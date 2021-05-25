package com.example.spring_bank_project.notification.application.useCase.sendAccountWasCreatedNotification;

import lombok.Value;

@Value
public class SendAccountWasCreatedNotificationCommand {
    SendAccountWasCreatedNotificationContract contract;
}
