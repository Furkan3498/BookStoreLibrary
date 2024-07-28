package com.example.BookStoreLibrary.Controller;

import com.example.BookStoreLibrary.Request.LoginRequest;
import com.example.BookStoreLibrary.dto.TokenResponseDto;
import com.example.BookStoreLibrary.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody LoginRequest request){

        return ResponseEntity.ok(authService.login(request));


    }
}
