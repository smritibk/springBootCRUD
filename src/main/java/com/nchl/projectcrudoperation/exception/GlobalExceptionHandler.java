package com.nchl.projectcrudoperation.exception;

import com.nchl.projectcrudoperation.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleBookNotFound(
            BookNotFoundException exp
    ) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                exp.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }
}
