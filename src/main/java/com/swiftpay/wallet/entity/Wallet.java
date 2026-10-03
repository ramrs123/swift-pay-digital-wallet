package com.swiftpay.wallet.entity;

import com.swiftpay.wallet.enums.Currency;
import com.swiftpay.wallet.enums.WalletStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "wallets")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long walletId;
    @OneToOne(
            optional = false,
            orphanRemoval = true
    )
    @JoinColumn(
            name = "user_id",
            nullable = false,
            unique = true

    )
    private User user;
    @Setter
    @Getter
    private BigDecimal walletBalance;
    @Getter
    @Setter
    private Currency currencyType;
    @Getter
    @Setter
    private WalletStatus walletStatus;
    @Getter
    private Instant createdAt;
    @Setter
    private Instant updatedAt = null;

    protected Wallet(){};
    public Wallet(User user) {
        this.user = user;
        this.createdAt = Instant.now();
        this.walletBalance = new BigDecimal("0");
        this.currencyType = Currency.INR;
        this.walletStatus = WalletStatus.ACTIVE;
    }

    public void touch(){
        this.updatedAt = Instant.now();
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "walletBalance=" + walletBalance +
                ", currencyType=" + currencyType +
                ", walletStatus=" + walletStatus +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
