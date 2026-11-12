package com.spring.spring_rest.exception;

/**
 * Indicates that a requested student does not exist.
 */
public class StudentNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -2690100046087976236L;

    /**
     * Creates the exception with a detail message.
     *
     * @param message explanation of the error
     */
    public StudentNotFoundException(String message) {
        super(message);
    }

    /**
     * Creates the exception with a cause.
     *
     * @param cause the underlying cause
     */
    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates the exception with a detail message and cause.
     *
     * @param message explanation of the error
     * @param cause the underlying cause
     */
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}