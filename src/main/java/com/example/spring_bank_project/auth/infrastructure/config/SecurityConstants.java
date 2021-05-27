package com.example.spring_bank_project.auth.infrastructure.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter
public class SecurityConstants {
    private final String secret;
    private final String issuer;
    private final int jwtExpriationTime;

    public SecurityConstants(@Value("${SECRET}") String secret, @Value("${BASE_URL}") String issuer,
            @Value("${JWT_EXPIRATION_TIME}") int jwtExpirationTime) {
        this.secret = secret;
        this.issuer = issuer;
        this.jwtExpriationTime = jwtExpirationTime;
    }
}
