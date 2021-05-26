package com.example.spring_bank_project.account.infrastructure.entity;

import com.example.spring_bank_project.account.application.useCase.addNewUser.PinEncoder;
import com.example.spring_bank_project.shared.domain.valueObject.UserId;
import com.example.spring_bank_project.shared.domain.valueObject.EncodedPin;
import com.example.spring_bank_project.shared.domain.valueObject.Pin;
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

    public UserId getUserId() {
        return new UserId(this.id);
    }

    public boolean isPinMatches(Pin pin, PinEncoder pinEncoder) {
        return pinEncoder.match(pin, new EncodedPin(this.pin));
    }
}
