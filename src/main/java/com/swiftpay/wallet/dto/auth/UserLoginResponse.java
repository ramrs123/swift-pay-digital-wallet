package com.swiftpay.wallet.dto.auth;

import com.swiftpay.wallet.entity.Wallet;

public record UserLoginResponse(
        String username,
        String token,
        String message,
        Wallet wallet
) {
}
