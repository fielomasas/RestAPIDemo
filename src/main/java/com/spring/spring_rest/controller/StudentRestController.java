package com.spring.spring_rest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.service.StudentService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Exposes REST endpoints for managing students.
 */
@RestController 
@RequestMapping("/api/students")
public class StudentRestController {

    private StudentService studentService;

    /**
     * Creates the controller with its student service dependency.
     *
     * @param studentService service used to perform student operations
     */
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Creates a student from the submitted request body.
     *
     * @param theStudentDto student data to create
     * @return the created student with an HTTP 201 response
     */
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@Valid 
                            @RequestBody StudentDto theStudentDto) {
        StudentDto saved = studentService.createStudent(theStudentDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    /**
     * Retrieves a student by ID.
     *
     * @param id ID of the student to retrieve
     * @return the requested student
     */
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }

    /**
     * Retrieves all students.
     *
     * @return the list of students
     */
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudent();
        return ResponseEntity.ok(students); 
    }
    
    /**
     * Replaces a student's data with the submitted request body.
     *
     * @param id ID of the student to update
     * @param theStudentDto replacement student data
     * @return the updated student
     */
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,
        @Valid @RequestBody StudentDto theStudentDto
    ) {
        StudentDto studentDto = studentService.updateStudent(id, 
            theStudentDto);
        return ResponseEntity.ok(studentDto);
    }

    /**
     * Partially updates a student's data with the submitted request body.
     *
     * @param id ID of the student to update
     * @param theStudentDto student fields to update
     * @return the updated student
     */
    @PatchMapping("{id}")
    public ResponseEntity<StudentDto> patchStudent(@PathVariable Long id,
        @Valid @RequestBody StudentDto theStudentDto
    ) {
        StudentDto studentDto = studentService.patchStudent(id, theStudentDto);
        return ResponseEntity.ok(studentDto);
    }

    /**
     * Deletes a student by ID.
     *
     * @param id ID of the student to delete
     * @return a success message
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }

}
