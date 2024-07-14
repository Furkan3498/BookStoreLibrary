package com.example.BookStoreLibrary.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNameNotFoundException extends RuntimeException {

    public UserNameNotFoundException(String message) {
        super(message);
}
}
