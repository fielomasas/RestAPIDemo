package com.spring.spring_rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a student record stored in the database.
 */
@Entity 
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "first_name", nullable = false)
    private String firstName;

    @Column (name = "last_name", nullable = false)
    private String lastName;

    @Column (name = "email", nullable = false, unique = true)
    private String email;

    /**
     * Creates an empty student entity for persistence frameworks.
     */
    public Student() {
    }

    /**
     * Creates a student with an ID and all student fields.
     *
     * @param id student ID
     * @param firstName student's first name
     * @param lastName student's last name
     * @param email student's email address
     */
    public Student(Long id, 
                    String firstName, 
                    String lastName, 
                    String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Creates a student with a first and last name.
     *
     * @param firstName student's first name
     * @param lastName student's last name
     */
    public Student(String firstName, 
                    
                    String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
     * Returns the student's ID.
     *
     * @return the student ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the student's ID.
     *
     * @param id the student ID
     */
    public void setId(Long id) {
        this.id = id;
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
