package com.example.spring_bank_project.auth.infrastructure.adapter.auth;

import com.example.spring_bank_project.auth.application.valueObject.AuthenticatedUserId;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtTokenFactory {
    private final String secret;
    private final String issuer;

    public JwtTokenFactory(@Value("${SECRET}") String secret, @Value("${BASE_URL}") String issuer) {
        this.secret = secret;
        this.issuer = issuer;
    }

    public String createToken(AuthenticatedUserId authenticatedUserId) {
        var key = Keys.hmacShaKeyFor(this.secret.getBytes(StandardCharsets.UTF_8));

        return this.buildJws(authenticatedUserId, key);
    }

    private String buildJws(AuthenticatedUserId authenticatedUserId, Key key) {
        return Jwts.builder()
                   .signWith(key)
                   .setIssuer(this.issuer)
                   .setSubject(authenticatedUserId.getId().toString())
                   .setExpiration(Date.from(Instant.now().plusSeconds(600)))
                   .compact();
    }
}
