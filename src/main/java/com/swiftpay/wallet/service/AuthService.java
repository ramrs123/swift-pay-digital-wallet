package com.swiftpay.wallet.service;

import com.swiftpay.wallet.dto.auth.UserLoginRequest;
import com.swiftpay.wallet.dto.auth.UserLoginResponse;
import com.swiftpay.wallet.dto.auth.UserRegisterRequest;
import com.swiftpay.wallet.dto.auth.UserRegisterResponse;
import com.swiftpay.wallet.entity.User;
import com.swiftpay.wallet.exception.UserAlreadyExistsException;
import com.swiftpay.wallet.exception.InvalidCredentialsException;
import com.swiftpay.wallet.repository.UserRepository;
import com.swiftpay.wallet.security.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Transactional
    public UserRegisterResponse register(UserRegisterRequest request){

            if(repository.existsByUsername(request.getUsername())){

                    throw new UserAlreadyExistsException("User already exists with these credentials");
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
                    "User created sucessfully",
                    savedUser.getWallet()

            );
    }

    //login

    public UserLoginResponse login(UserLoginRequest request){
        User savedUser = repository.findByUsername(request.getUsername());

        if(savedUser == null){

            throw new InvalidCredentialsException("Invalid Credentials");
        }

        if(!passwordEncoder.matches(request.getPassword(), savedUser.getPasswordHash())){

            throw new InvalidCredentialsException("Invalid Credentials");

        }

        String token = jwtService.generateToken(savedUser);

        return new UserLoginResponse(
                savedUser.getUserName(),
                token,
                "Login Successful",
                savedUser.getWallet()
        );
    }

}
