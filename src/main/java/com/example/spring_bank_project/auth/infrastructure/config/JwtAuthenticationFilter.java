package com.example.spring_bank_project.auth.infrastructure.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("NullableProblems")
@Service
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenExtractor jwtTokenExtractor;
    private final ApplicationUserDetailsService userDetailsService;
    private final PublicEndpointsFilter publicEndpointsFilter;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        if (this.publicEndpointsFilter.isPublic(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        var jwtToken = this.jwtTokenExtractor.extractJwtTokenFromRequest(request);
        var userId = this.jwtTokenExtractor.extractUserIdFromJwtToken(jwtToken);
        var user = this.userDetailsService.loadByUserId(userId);

        this.setSecurityAuthentication(user, request);

        filterChain.doFilter(request, response);
    }

    private void setSecurityAuthentication(UserDetails user, HttpServletRequest request) {
        var authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }
}
