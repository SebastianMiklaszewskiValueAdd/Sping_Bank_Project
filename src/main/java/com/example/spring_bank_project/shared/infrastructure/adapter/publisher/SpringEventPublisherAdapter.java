package com.example.spring_bank_project.shared.infrastructure.adapter.publisher;

import com.example.spring_bank_project.shared.domain.event.Event;
import com.example.spring_bank_project.shared.domain.event.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SpringEventPublisherAdapter implements EventPublisher {
    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(Event event) {
        this.publisher.publishEvent(event);
    }
}
