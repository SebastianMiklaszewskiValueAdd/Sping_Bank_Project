package com.example.spring_bank_project.auth.infrastructure.adapter.auth;

import com.example.spring_bank_project.auth.application.valueObject.AuthenticatedUserId;
import com.example.spring_bank_project.auth.infrastructure.config.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtTokenFactory {
    private final SecurityConstants securityConstants;

    public String createToken(AuthenticatedUserId authenticatedUserId) {
        var key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.securityConstants.getSecret()));

        return this.buildJws(authenticatedUserId, key);
    }

    private String buildJws(AuthenticatedUserId authenticatedUserId, Key key) {
        return Jwts.builder()
                   .signWith(key)
                   .setIssuer(this.securityConstants.getIssuer())
                   .setSubject(authenticatedUserId.getId().toString())
                   .setExpiration(Date.from(Instant.now().plusSeconds(this.securityConstants.getJwtExpriationTime())))
                   .compact();
    }
}
