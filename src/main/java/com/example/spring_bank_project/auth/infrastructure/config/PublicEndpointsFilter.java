package com.example.spring_bank_project.auth.infrastructure.config;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
class PublicEndpointsFilter {
    private final ArrayList<String> publicEndpoints = new ArrayList<>();

    public PublicEndpointsFilter() {
        this.publicEndpoints.add("/api/user/store");
        this.publicEndpoints.add("/api/auth/login");
    }

    public boolean isPublic(String uri) {
        return this.publicEndpoints.stream().anyMatch(publicUri -> publicUri.equals(uri));
    }
}
