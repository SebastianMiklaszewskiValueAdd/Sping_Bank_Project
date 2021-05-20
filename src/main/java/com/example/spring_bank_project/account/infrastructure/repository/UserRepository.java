package com.example.spring_bank_project.account.infrastructure.repository;

import com.example.spring_bank_project.account.infrastructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
