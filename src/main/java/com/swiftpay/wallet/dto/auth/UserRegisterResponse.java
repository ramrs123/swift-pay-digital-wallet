package com.swiftpay.wallet.dto.auth;

import com.swiftpay.wallet.entity.Wallet;

public record UserRegisterResponse(
        String username, String email, String message, Wallet wallet
) {
}
