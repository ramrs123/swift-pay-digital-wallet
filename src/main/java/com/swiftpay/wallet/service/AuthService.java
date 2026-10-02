package com.swiftpay.wallet.service;

import com.swiftpay.wallet.dto.auth.UserLoginRequest;
import com.swiftpay.wallet.dto.auth.UserLoginResponse;
import com.swiftpay.wallet.dto.auth.UserRegisterRequest;
import com.swiftpay.wallet.dto.auth.UserRegisterResponse;
import com.swiftpay.wallet.entity.User;
import com.swiftpay.wallet.repository.UserRepository;
import com.swiftpay.wallet.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

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

    public UserLoginResponse login(UserLoginRequest request){
        User savedUser = repository.findByUsername(request.getUsername());
        System.out.println("check-point-3");
        if(savedUser == null){
            System.out.println("Check-point-4");
            return new UserLoginResponse(
                    null,
                    null,
                    "No user found with these credentials"

            );
        }

        if(passwordEncoder.matches(request.getPassword(), savedUser.getPasswordHash())){
            //generate jwt and return
            System.out.println("Check-point-5");
            String token = jwtService.generateToken(savedUser);

            return new UserLoginResponse(
                    savedUser.getUserName(),
                    token,
                    "Login Successful"
            );
        }
        System.out.println("Check-point-6");
        return new UserLoginResponse(
                request.getUsername(),
                request.getPassword(),
                "Invalid Credentials"
        );
    }

}
