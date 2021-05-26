package com.example.spring_bank_project.account.infrastructure.entity;

import com.example.spring_bank_project.account.domain.valueObject.Currency;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "finance")
@NoArgsConstructor
@Setter
public class Finance {
    @Id
    @Column
    private UUID id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    @Column
    private BigDecimal dailyPaymentsLimit;

    @Column(nullable = false)
    private BigDecimal money = BigDecimal.valueOf(0.00);

    @OneToOne(targetEntity = Account.class)
    @JoinColumn(name = "account", nullable = false)
    private Account account;
}
