package com.br.installmentpaymentseasy.util;

import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
        return ResponseEntity.badRequest().body(new ExceptionDetails(
                exception.getMessage(),
                400,
                "Bad Request",
                exception.getMessage(),
                "/api/parcelamento"));
    }

}
