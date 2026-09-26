package com.swiftpay.wallet.service;

import com.swiftpay.wallet.dto.auth.UserRegisterRequest;
import com.swiftpay.wallet.dto.auth.UserRegisterResponse;
import com.swiftpay.wallet.entity.User;
import com.swiftpay.wallet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserRegisterResponse register(UserRegisterRequest request){

            if(repository.existsByUsername(request.getUsername())){

                    return new UserRegisterResponse(
                            request.getUsername(),
                            request.getUserEmailAddress(),
                            "User Already exists..."
                    );
            }

            String hashedPassword = passwordEncoder.encode(request.getPassword());
            User user = new User(
                    request.getUsername(),
                    request.getUserEmailAddress(),
                    hashedPassword
            );


            User savedUser = repository.save(user);
            return new UserRegisterResponse(
                    savedUser.getUserName(),
                    savedUser.getUserEmailAddress(),
                    "User created sucessfully"
            );
    }

    //login

}
