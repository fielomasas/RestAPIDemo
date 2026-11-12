package com.spring.spring_rest.service;

import java.util.List;

import com.spring.spring_rest.dto.StudentDto;

/**
 * Defines operations for managing students.
 */
public interface StudentService {
    /**
     * Creates a student.
     *
     * @param theStudentDto data for the student to create
     * @return the created student
     */
    StudentDto createStudent(StudentDto theStudentDto);

    /**
     * Retrieves a student by ID.
     *
     * @param id ID of the student to retrieve
     * @return the requested student
     */
    StudentDto getStudentById(Long id);

    /**
     * Retrieves all students.
     *
     * @return all students
     */
    List<StudentDto> getAllStudent();

    /**
     * Replaces a student's data.
     *
     * @param id ID of the student to update
     * @param studentDto replacement student data
     * @return the updated student
     */
    StudentDto updateStudent(Long id, StudentDto studentDto);

    /**
     * Partially updates a student's data.
     *
     * @param theId ID of the student to update
     * @param theStudentDto student fields to update
     * @return the updated student
     */
    StudentDto patchStudent(Long theId, StudentDto theStudentDto);

    /**
     * Deletes a student by ID.
     *
     * @param theId ID of the student to delete
     */
    void deleteStudentById(Long theId);
}
