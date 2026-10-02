package com.swiftpay.wallet.dto.auth;

public record UserLoginResponse(
        String username,
        String token,
        String message
) {
}
