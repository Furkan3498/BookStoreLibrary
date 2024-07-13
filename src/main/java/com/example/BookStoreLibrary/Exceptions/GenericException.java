package com.example.BookStoreLibrary.Exceptions;

import com.example.BookStoreLibrary.dto.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class GenericException {

    private HttpStatus httpStatus;
    private String message;
    private ErrorCode errorCode;
}
