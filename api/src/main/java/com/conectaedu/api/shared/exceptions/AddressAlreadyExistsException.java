package com.conectaedu.api.shared.exceptions;

public class AddressAlreadyExistsException extends RuntimeException {
    public AddressAlreadyExistsException(String message) {
        super(message);
    }
}
