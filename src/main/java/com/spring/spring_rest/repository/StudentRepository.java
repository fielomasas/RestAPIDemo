package com.spring.spring_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring_rest.entity.Student;

/**
 * Provides persistence operations for student entities.
 */
public interface StudentRepository extends JpaRepository<Student, Long>{

    /**
     * Checks whether a student already uses the given email address.
     *
     * @param email email address to check
     * @return {@code true} if a student uses the email, 
     * otherwise {@code false}
     */
    boolean existsByEmail(String email);

    /**
     * Checks whether another student uses the given email address.
     *
     * @param email email address to check
     * @param id ID of the student to exclude from the check
     * @return {@code true} if another student uses the email, 
     * otherwise {@code false}
     */
    boolean existsByEmailAndIdNot(String email, Long id);
}
