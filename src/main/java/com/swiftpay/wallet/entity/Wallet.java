package com.swiftpay.wallet.entity;

import com.swiftpay.wallet.enums.Currency;
import com.swiftpay.wallet.enums.WalletStatus;

import java.math.BigDecimal;
import java.time.Instant;

public class Wallet {
    private int walletId;
    private int userId;
    private BigDecimal walletBalance;
    private Currency currencyType;
    private WalletStatus walletStatus;
    private final Instant createdAt;
    private Instant updatedAt;

    public Wallet(Instant createdAt, BigDecimal walletBalance, Currency currencyType, WalletStatus walletStatus) {
        this.createdAt = createdAt;
        this.walletBalance = new BigDecimal("0");
        this.currencyType = Currency.INR;
        this.walletStatus = WalletStatus.ACTIVE;
    }

    public BigDecimal getWalletBalance() {
        return walletBalance;
    }

    public Currency getCurrencyType() {
        return currencyType;
    }

    public WalletStatus getWalletStatus() {
        return walletStatus;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCurrencyType(Currency currencyType) {
        this.currencyType = currencyType;
    }

    public void setWalletStatus(WalletStatus walletStatus) {
        this.walletStatus = walletStatus;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setWalletBalance(BigDecimal walletBalance) {
        this.walletBalance = walletBalance;
    }

    public void touch(){
        this.updatedAt = Instant.now();
    }
}
