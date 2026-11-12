package com.spring.spring_rest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.service.StudentService;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequestMapping("/api/students")
public class StudentRestController {

    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Add Students REST API
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@Valid 
                            @RequestBody StudentDto theStudentDto) {
        StudentDto saved = studentService.createStudent(theStudentDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Get Student By Id REST API
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }

    // Get All Students REST API
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudent();
        return ResponseEntity.ok(students); 
    }
    
    // Update Student REST API
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,
        @Valid @RequestBody StudentDto theStudentDto
    ) {
        StudentDto studentDto = studentService.updateStudent(id, theStudentDto);
        return ResponseEntity.ok(studentDto);
    }

    // Patch Student REST API
    @PatchMapping("{id}")
    public ResponseEntity<StudentDto> patchStudent(@PathVariable Long id,
        @Valid @RequestBody StudentDto theStudentDto
    ) {
        StudentDto studentDto = studentService.patchStudent(id, theStudentDto);
        return ResponseEntity.ok(studentDto);
    }

    // Delete Student REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }

    // Old Implementation (Disregard)
    // private List<Student> theStudents;

    // @PostConstruct
    // public void initialize() {
    //     theStudents = new ArrayList<>();

    //     theStudents.add(new Student("Light", "Yagami"));
    //     theStudents.add(new Student("Leslie", "Andrews"));
    //     theStudents.add(new Student("Fiel", "Omas-as"));
    // }

    // @GetMapping("/students")
    // public List<Student> getStudents() {
    //     return theStudents;
    // }

    // @GetMapping("/students/{studentId}")
    // public Student getsStudent(@PathVariable int studentId) {

    //     if (studentId >= theStudents.size() || (studentId < 0)) {
    //         throw new StudentNotFoundException(
    //             "Student id " + studentId + " not found"
    //         );
    //     }
    //     return theStudents.get(studentId);
    // }
}
