package com.spring.spring_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.spring_rest.entity.Student;

/**
 * Provides persistence operations for student entities.
 */
public interface StudentRepository extends JpaRepository<Student, Long>{

}
