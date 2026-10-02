package com.swiftpay.wallet.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserLoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}


