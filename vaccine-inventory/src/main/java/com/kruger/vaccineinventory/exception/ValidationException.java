package com.kruger.vaccineinventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ValidationException extends Exception {
    private static final long serialVersionUID = 1L;
    public ValidationException(String message) {
        super(message);
    }
}