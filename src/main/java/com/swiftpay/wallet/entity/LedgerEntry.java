package com.swiftpay.wallet.entity;

import com.swiftpay.wallet.enums.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;

public final class LedgerEntry {
    private Long ledgerId;
    private int walletId;
    private Long transactionId;
    private TransactionType transactionType;
    private BigDecimal amount;
    private BigDecimal accountBalance;
    private final Instant createdAt;

    public LedgerEntry(TransactionType transactionType, BigDecimal amount, BigDecimal accountBalance) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.accountBalance = accountBalance;
        this.createdAt = Instant.now();
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

}
