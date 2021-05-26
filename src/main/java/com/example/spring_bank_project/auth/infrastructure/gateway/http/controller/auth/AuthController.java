package com.example.spring_bank_project.auth.infrastructure.gateway.http.controller.auth;

import com.example.spring_bank_project.auth.application.AuthFacade;
import com.example.spring_bank_project.auth.application.useCase.login.UserAuthorizedView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
public class AuthController {
    private final AuthFacade facade;

    @GetMapping(path = "/login")
    public ResponseEntity<UserAuthorizedView> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(this.facade.login(request));
    }
}
