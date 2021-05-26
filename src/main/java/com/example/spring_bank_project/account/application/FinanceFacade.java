package com.example.spring_bank_project.account.application;

import com.example.spring_bank_project.account.application.useCase.configureAccountFinances.ConfigureAccountFinancesCommand;
import com.example.spring_bank_project.account.application.useCase.configureAccountFinances.ConfigureAccountFinancesContract;
import com.example.spring_bank_project.account.application.useCase.configureAccountFinances.ConfigureAccountFinancesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinanceFacade {
    private final ConfigureAccountFinancesHandler handler;

    public void configureAccountFinances(ConfigureAccountFinancesContract contract) {
        this.handler.handle(new ConfigureAccountFinancesCommand(contract));
    }
}
