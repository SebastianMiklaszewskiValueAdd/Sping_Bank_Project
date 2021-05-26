package com.example.spring_bank_project.account.infrastructure.gateway.http.controller.finance;

import com.example.spring_bank_project.account.application.FinanceFacade;
import com.example.spring_bank_project.account.infrastructure.entity.Finance;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/finance")
class FinanceController {
    private final FinanceFacade facade;

    @PostMapping("/store")
    public ResponseEntity<Finance> store(@RequestBody @Valid StoreNewFinancesRequest request) {
        this.facade.configureAccountFinances(request);

        return ResponseEntity.created(URI.create("/api/finance/store")).build();
    }
}
