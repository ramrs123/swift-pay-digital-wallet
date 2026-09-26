package com.swiftpay.wallet.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserRegisterRequest {
    @NotBlank
    @Pattern(
            regexp = "^@[a-z](?=.*[0-9])[a-z0-9]*$",
            message = "Username is not valid eg:@john01"
    )
    private final String username;
    @NotBlank
    @Pattern(
            regexp = "^[a-zA-Z0-9]+@gmail\\.com$",
            message = "Invalid Email Id"
    )
    private String userEmailAddress;
    @NotBlank
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$",
            message = "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one number, and one special character"
    )
    private String password;

    public UserRegisterRequest(String username, String userEmailAddress, String password) {
        this.username = username;
        this.userEmailAddress = userEmailAddress;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public String getPassword() {
        return password;
    }
}
