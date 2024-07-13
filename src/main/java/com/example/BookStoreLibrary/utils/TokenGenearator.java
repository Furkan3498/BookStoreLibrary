package com.example.BookStoreLibrary.utils;

import com.amazonaws.services.dynamodbv2.xspec.S;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class TokenGenearator {


    @Value("${jwt-variables.KEY}")
    private String KEY;
    @Value("${jwt-variables.ISSUER}")
    private String ISSUER;


    @Value("${jwt-variables.EXPIRES_ACCESS_TOKEN_MINUTES}")
    private Integer EXPIRES_ACCESS_TOKEN_MINUTES;


    public String generateToken(Authentication authentication){
        String username = ((UserDetails)authentication.getPrincipal()).getUsername();
        return JWT.create()
                .withSubject(username)
                .withIssuer(ISSUER)
                .withExpiresAt( new Date(System.currentTimeMillis()+ (EXPIRES_ACCESS_TOKEN_MINUTES * 60 * 1000)))
                .sign(Algorithm.HMAC256(KEY.getBytes()));
    }
}
