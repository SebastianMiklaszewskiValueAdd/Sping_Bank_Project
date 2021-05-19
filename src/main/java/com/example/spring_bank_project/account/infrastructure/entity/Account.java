package com.example.spring_bank_project.account.infrastructure.entity;

import com.example.spring_bank_project.account.domain.valueObject.AccountType;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "account")
@NoArgsConstructor
@Setter
public class Account {
    @Id
    @Column()
    private UUID id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AccountType type;

    @Column(nullable = false)
    private Instant createdAt;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "owner", nullable = false)
    private User owner;
}
