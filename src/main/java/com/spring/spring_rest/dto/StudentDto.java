package com.spring.spring_rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

/**
 * Carries student data between the REST API and service layer.
 */
public class StudentDto {
    private Long id;

    @Size (min = 2, max = 50, message = "Must be 2 to 50 characters.")
    private String firstName;

    @Size (min = 2, max = 50, message = "Must be 2 to 50 characters.")
    private String lastName;

    @Email (message = "Emails is required and should be valid.")
    private String email;

    /**
     * Creates a student data transfer object.
     *
     * @param id student ID
     * @param firstName student's first name
     * @param lastName student's last name
     * @param email student's email address
     */
    public StudentDto(Long id, 
                        String firstName, 
                        String lastName, 
                        String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Returns the student ID.
     *
     * @return the student ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the student ID.
     *
     * @param id the student ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the student's first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the student's last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the student's last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the student's email address.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the student's email address.
     *
     * @param email the email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
