package com.swiftpay.wallet.dto.auth;

public record UserRegisterResponse(
        String username, String email, String message
) {
}
