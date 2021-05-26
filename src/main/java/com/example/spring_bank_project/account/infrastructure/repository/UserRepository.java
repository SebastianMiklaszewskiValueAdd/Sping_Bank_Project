package com.example.spring_bank_project.account.infrastructure.repository;

import com.example.spring_bank_project.account.infrastructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
