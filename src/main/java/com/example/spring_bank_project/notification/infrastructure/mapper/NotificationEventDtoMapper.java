package com.example.spring_bank_project.notification.infrastructure.mapper;

import com.example.spring_bank_project.notification.domain.valueObject.Contact;
import com.example.spring_bank_project.notification.domain.valueObject.ContactType;
import com.example.spring_bank_project.notification.infrastructure.gateway.listener.SendAccountWasCreatedNotificationDto;
import com.example.spring_bank_project.shared.domain.event.AccountWasCreated;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationEventDtoMapper {
    @Mapping(target = "contact", expression = "java(this.emailToContactValueObject(event.getEmail()))")
    @Mapping(target = "recipientFullName", source = "event.userFullName")
    SendAccountWasCreatedNotificationDto eventToSendAccountWasCreatedNotificationDto(AccountWasCreated event);

    default Contact emailToContactValueObject(String email) {
        return new Contact(email, ContactType.EMAIL);
    }
}
