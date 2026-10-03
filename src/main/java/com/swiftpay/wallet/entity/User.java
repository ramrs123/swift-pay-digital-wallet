package com.swiftpay.wallet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long userId;
    @Column(name = "username", unique = true, updatable = false)
    private String username;
    @Getter
    @Setter
    @Column(name = "email", unique = true)
    private String userEmailAddress;
    @Getter
    private String passwordHash;
    @Getter
    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            optional = false,
            orphanRemoval = true
    )
    private Wallet wallet;
    @Getter
    private Instant createdAt;
    @Getter
    private Instant updatedAt;

    protected User(){};

    public User(String username, String userEmailAddress, String passwordHash) {
        Instant now = Instant.now();
        this.username = username;
        this.userEmailAddress = userEmailAddress;
        this.passwordHash = passwordHash;
        this.createdAt = now;
        this.wallet = new Wallet(this);

    }

    public String getUserName() {
        return username;
    }


    public void touch(){
        this.updatedAt = Instant.now();
    }
}
