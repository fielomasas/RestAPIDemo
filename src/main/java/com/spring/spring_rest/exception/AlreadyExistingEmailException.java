package com.spring.spring_rest.exception;

public class AlreadyExistingEmailException extends RuntimeException {

    public AlreadyExistingEmailException(String message) {
        super(message);
    }

    public AlreadyExistingEmailException(Throwable cause) {
        super(cause);
    }

    public AlreadyExistingEmailException(String message, Throwable cause) {
        super(message, cause);
    }

}
