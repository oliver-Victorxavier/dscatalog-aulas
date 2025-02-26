package com.devsuperior.dscatalog.services.exceptions;

import org.springframework.context.annotation.Configuration;

import java.io.Serial;


public class DatabaseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public DatabaseException(String message) {
        super(message);
    }
}
