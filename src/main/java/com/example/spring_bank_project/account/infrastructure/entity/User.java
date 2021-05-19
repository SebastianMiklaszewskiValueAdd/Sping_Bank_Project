package com.example.spring_bank_project.account.infrastructure.entity;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity()
@Table(name = "`user`")
@NoArgsConstructor
@Setter
public class User {
    @Id
    @Column(nullable = false, unique = true, updatable = false)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, updatable = false)
    private LocalDate birthDate;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String pin;

    @Column(nullable = false)
    private Instant createdAt;

    @OneToMany(targetEntity = Account.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "owner")
    private Set<Account> accounts;
}
