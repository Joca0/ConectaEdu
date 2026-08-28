package com.conectaedu.api.shared.exceptions;

public class SchoolNotFoundException extends RuntimeException {
    public SchoolNotFoundException(String message) {
        super(message);
    }
}
