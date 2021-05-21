package com.example.spring_bank_project.shared.domain.factory;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UuidFactory {
    public UUID newUuid() {
        return UUID.randomUUID();
    }
}
