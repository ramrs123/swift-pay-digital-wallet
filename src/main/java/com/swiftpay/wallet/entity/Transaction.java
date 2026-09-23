package com.swiftpay.wallet.entity;

import com.swiftpay.wallet.enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.Instant;

public class Transaction {
    private Long transactionId;
    private int senderWalletId;
    private int receiverWalletId;
    private BigDecimal amount;
    private TransactionStatus transactionStatus;
    private Long referenceId;
    private String transactionNotes;
    private final Instant createdAt;

    public Transaction(int senderWalletId, int receiverWalletId, BigDecimal amount, String transactionNotes) {
        this.createdAt = Instant.now();
        this.senderWalletId = senderWalletId;
        this.receiverWalletId = receiverWalletId;
        this.amount = amount;
        this.transactionStatus = TransactionStatus.INITIATED;
        this.transactionNotes = transactionNotes;
    }

    public int getSenderWalletId() {
        return senderWalletId;
    }

    public int getReceiverWalletId() {
        return receiverWalletId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public String getTransactionNotes() {
        return transactionNotes;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setSenderWalletId(int senderWalletId) {
        this.senderWalletId = senderWalletId;
    }

    public void setReceiverWalletId(int receiverWalletId) {
        this.receiverWalletId = receiverWalletId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTransactionNotes(String transactionNotes) {
        this.transactionNotes = transactionNotes;
    }
}
