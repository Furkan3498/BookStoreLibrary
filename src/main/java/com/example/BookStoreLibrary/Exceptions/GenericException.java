package com.example.BookStoreLibrary.Exceptions;

import com.example.BookStoreLibrary.dto.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.apache.http.HttpStatus;
@SuperBuilder
@NoArgsConstructor
@Getter
public class GenericException {

    private HttpStatus httpStatus;
    private ErrorCode errorCode;
}
