package com.example.BookStoreLibrary.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenGenerator {


    @Value("${jwt-variables.KEY}")
    private String KEY;
    @Value("${jwt-variables.ISSUER}")
    private String ISSUER;


    @Value("${jwt-variables.EXPIRES_ACCESS_TOKEN_MINUTES}")
    private long EXPIRES_ACCESS_TOKEN_MINUTES;


    public String generateToken(Authentication authentication){
        String username = ((UserDetails)authentication.getPrincipal()).getUsername();
        return JWT.create()
                .withSubject(username)
                .withIssuer(ISSUER)
                .withExpiresAt( new Date(System.currentTimeMillis()+ (EXPIRES_ACCESS_TOKEN_MINUTES * 60 * 1000)))
                .sign(Algorithm.HMAC256(KEY.getBytes()));
    }


    public DecodedJWT verifyJWT(String token){
        Algorithm algorithm = Algorithm.HMAC256(KEY.getBytes());

        JWTVerifier jwtVerifier= JWT.require(algorithm).build();
        return  jwtVerifier.verify(token);

       /* try {
            return  jwtVerifier.verify(token);
        }
        catch (Exception e ){
            throw GenericException.builder()
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .message(e.getMessage()).build();
        }
*/
    }
}




















