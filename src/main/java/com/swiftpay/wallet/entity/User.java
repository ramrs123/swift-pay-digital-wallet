package com.swiftpay.wallet.entity;

import java.time.Instant;

public class User {
    private int userId;
    private final String userName;
    private String userEmailAddress;
    private String password;
    private final Instant createdAt;
    private Instant updatedAt;

    public User(String userName, Instant createdAt, String userEmailAddress, String password) {
        this.userName = userName;
        this.createdAt = createdAt;
        this.userEmailAddress = userEmailAddress;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public String getUserName() {
        return userName;
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

    public String getPassword() {
        return password;
    }

    public void touch(){
        this.updatedAt = Instant.now();
    }
}
