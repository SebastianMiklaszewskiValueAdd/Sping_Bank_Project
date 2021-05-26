package com.example.spring_bank_project.account.infrastructure.repository;

import com.example.spring_bank_project.account.infrastructure.entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FinanceRepository extends JpaRepository<Finance, UUID> {
}
