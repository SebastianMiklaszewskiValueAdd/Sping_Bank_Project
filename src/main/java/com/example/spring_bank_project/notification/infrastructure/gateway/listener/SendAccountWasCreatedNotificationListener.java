package com.example.spring_bank_project.notification.infrastructure.gateway.listener;

import com.example.spring_bank_project.notification.application.AccountNotificationFacade;
import com.example.spring_bank_project.notification.infrastructure.mapper.NotificationEventDtoMapper;
import com.example.spring_bank_project.shared.domain.event.AccountWasCreated;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SendAccountWasCreatedNotificationListener {
    private final AccountNotificationFacade facade;
    private final NotificationEventDtoMapper mapper;

    @EventListener
    public void handle(AccountWasCreated event) {
        this.facade.sendAccountCreatedNotification(this.mapper.eventToSendAccountWasCreatedNotificationDto(event));
    }
}
