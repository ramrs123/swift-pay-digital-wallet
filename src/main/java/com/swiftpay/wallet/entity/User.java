package com.swiftpay.wallet.entity;

import jakarta.persistence.*;

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
    @Column(name = "email", unique = true)
    private String userEmailAddress;
    private String passwordHash;
    private Instant createdAt;
    private Instant updatedAt;

    protected User(){};

    public User(String username, String userEmailAddress, String passwordHash) {
        this.username = username;
        this.userEmailAddress = userEmailAddress;
        this.passwordHash = passwordHash;
        this.createdAt = Instant.now();
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public String getUserName() {
        return username;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }


    public void touch(){
        this.updatedAt = Instant.now();
    }
}
