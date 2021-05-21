package com.example.spring_bank_project.shared.domain.event;

import lombok.ToString;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

@ToString
public class Event extends ApplicationEvent {
    UUID eventId = UUID.randomUUID();

    public Event(Object source) {
        super(source);
    }
}
