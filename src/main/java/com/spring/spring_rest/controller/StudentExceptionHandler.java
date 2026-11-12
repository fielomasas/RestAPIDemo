package com.spring.spring_rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.spring_rest.entity.StudentErrorResponse;
import com.spring.spring_rest.exception.AlreadyExistingEmailException;
import com.spring.spring_rest.exception.StudentNotFoundException;

import java.util.Map;
import java. util.HashMap;

/**
 * Converts exceptions raised by student endpoints into HTTP responses.
 */
@ControllerAdvice 
public class StudentExceptionHandler {

    /**
     * Builds a not-found response for a missing student.
     *
     * @param ex exception describing the missing student
     * @return the error response with HTTP 404 status
     */
    @ExceptionHandler 
    public ResponseEntity<StudentErrorResponse> handleException(
        StudentNotFoundException ex) {

        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ex.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    /**
     * Builds a bad-request response for an exception 
     * without a specific handler.
     *
     * @param ex exception raised while handling the request
     * @return the error response with HTTP 400 status
     */
    @ExceptionHandler 
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage("Invalid data. Only integers are accepted.");
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    /**
     * Collects validation errors by field.
     *
     * @param ex exception containing the request validation errors
     * @return a map of field names to validation messages
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions (
        MethodArgumentNotValidException ex) {
        Map<String, String> err = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            err.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    /**
     * Builds a conflict response for a duplicate student email.
     *
     * @param ex exception describing the duplicate email
     * @return the error response with HTTP 409 status
     */
    @ExceptionHandler(AlreadyExistingEmailException.class)
    public ResponseEntity<StudentErrorResponse> handleExistingEmail(
            AlreadyExistingEmailException ex) {

        StudentErrorResponse err = new StudentErrorResponse();
        err.setStatus(HttpStatus.CONFLICT.value());
        err.setMessage(ex.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.CONFLICT);
    }
}
