package com.example.spring_bank_project.Shared.Presentation.CommandBus;

public interface CommandBusPort {
    void dispatchNow(CommandInterface command);
}
