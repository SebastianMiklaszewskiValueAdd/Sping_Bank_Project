package com.example.spring_bank_project.auth.infrastructure.config;

import com.example.spring_bank_project.auth.application.exception.AuthorizeException;
import com.example.spring_bank_project.shared.domain.valueObject.UserId;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtTokenExtractor {
    private final SecurityConstants securityConstants;

    public String extractJwtTokenFromRequest(HttpServletRequest request) {
        var bearer = Optional.ofNullable(request.getHeader("Authorization"));

        this.assertBearerIsValid(bearer);

        return this.extractJwtTokenFromBearer(bearer);
    }

    public UserId extractUserIdFromJwtToken(String jwtToken) {
        var body = Jwts.parserBuilder()
                       .setSigningKey(this.securityConstants.getSecret())
                       .requireIssuer(this.securityConstants.getIssuer())
                       .build()
                       .parseClaimsJws(jwtToken)
                       .getBody();

        return new UserId(body.getSubject());
    }

    private void assertBearerIsValid(Optional<String> bearer) {
        bearer.map(presetBearer -> !presetBearer.isEmpty() && presetBearer.startsWith(
                "Bearer ")).orElseThrow(() -> new AuthorizeException("Bearer token is not present or is invalid."));
    }

    private String extractJwtTokenFromBearer(Optional<String> bearer) {
        return bearer.map(presentBearer -> presentBearer.replaceFirst("Bearer ", ""))
                     .orElseThrow(() -> new AuthorizeException("Cannot extract JWT token from bearer."));
    }
}
