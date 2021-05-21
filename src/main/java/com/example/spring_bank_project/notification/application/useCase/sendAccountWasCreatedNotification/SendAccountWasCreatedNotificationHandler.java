package com.example.spring_bank_project.notification.application.useCase.sendAccountWasCreatedNotification;

import com.example.spring_bank_project.notification.application.port.NotificationSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendAccountWasCreatedNotificationHandler {
    private final AccountWasCreatedNotificationFactory factory;
    @Qualifier("strategy") private final NotificationSender notificationSender;

    public void handle(SendAccountWasCreatedNotificationCommand command) {
        var contract = command.getContract();

        var notification = this.factory.create(contract.getRecipientFullName(),
                contract.getAccountType(),
                contract.getCreatedAt(),
                contract.getContact());

        this.notificationSender.send(notification);
    }
}
