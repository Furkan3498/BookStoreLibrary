package com.example.BookStoreLibrary.service;

import com.example.BookStoreLibrary.Exceptions.GenericException;
import com.example.BookStoreLibrary.Exceptions.UserNameNotFoundException;
import com.example.BookStoreLibrary.Request.LoginRequest;
import com.example.BookStoreLibrary.dto.ErrorCode;
import com.example.BookStoreLibrary.dto.TokenResponseDto;
import com.example.BookStoreLibrary.utils.TokenGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenGenerator tokenGenerator;

    public AuthService(UserService userService, AuthenticationManager authenticationManager, TokenGenerator tokenGenerator) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenGenerator = tokenGenerator;
    }

    public TokenResponseDto login(LoginRequest request) {


            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
                    return  TokenResponseDto.builder()
                            .accessToken(tokenGenerator.generateToken(authentication))
                            .userDto(userService.getUser(request.getUsername()))
                            .build();
            }catch (Exception e){
                throw new UserNameNotFoundException("User details couldn't be found by following id : " );
            }

    }
}
