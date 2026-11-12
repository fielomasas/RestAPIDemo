package com.spring.spring_rest.entity;

/**
 * Represents the error details returned by the REST API.
 */
public class StudentErrorResponse {
    
    private int status;
    private String message;
    private long timeStamp;

    /**
     * Creates an empty error response.
     */
    public StudentErrorResponse() {
    }

    /**
     * Creates an error response with all fields populated.
     *
     * @param status HTTP status code
     * @param message error description
     * @param timeStamp time the error response was created
     */
    public StudentErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    /**
     * Returns the HTTP status code.
     *
     * @return the status code
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the HTTP status code.
     *
     * @param status the status code
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Returns the error description.
     *
     * @return the error message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the error description.
     *
     * @param message the error message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Returns the time the error response was created.
     *
     * @return the timestamp
     */
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the time the error response was created.
     *
     * @param timeStamp the timestamp
     */
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
