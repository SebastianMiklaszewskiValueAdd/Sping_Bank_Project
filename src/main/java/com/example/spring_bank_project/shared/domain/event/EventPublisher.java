package com.example.spring_bank_project.shared.domain.event;

public interface EventPublisher {
    void publish(Event event);
}
