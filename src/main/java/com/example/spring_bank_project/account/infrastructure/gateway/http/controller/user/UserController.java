package com.example.spring_bank_project.account.infrastructure.gateway.http.controller.user;

import com.example.spring_bank_project.account.application.UserFacade;
import com.example.spring_bank_project.account.infrastructure.entity.User;
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
@RequestMapping(path = "/api/user")
public class UserController {
    private final UserFacade facade;

    @PostMapping(path = "/store")
    public ResponseEntity<User> store(@RequestBody @Valid AddNewUserRequest request) {
        this.facade.addNewUser(request);

        return ResponseEntity.created(URI.create("/api/user/store")).build();
    }
}
