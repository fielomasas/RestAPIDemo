package com.spring.spring_rest.exception;

/**
 * Indicates that a student email address is already in use.
 */
public class AlreadyExistingEmailException extends RuntimeException {

    /**
     * Creates the exception with a detail message.
     *
     * @param message explanation of the duplicate email
     */
    public AlreadyExistingEmailException(String message) {
        super(message);
    }

    /**
     * Creates the exception with an underlying cause.
     *
     * @param cause the cause of the exception
     */
    public AlreadyExistingEmailException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates the exception with a detail message and an underlying cause.
     *
     * @param message explanation of the duplicate email
     * @param cause the cause of the exception
     */
    public AlreadyExistingEmailException(String message, Throwable cause) {
        super(message, cause);
    }

}
