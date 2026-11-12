package com.spring.spring_rest.service;

import java.util.List;

import com.spring.spring_rest.dto.StudentDto;

public interface StudentService {
    StudentDto createStudent(StudentDto theStudentDto);
    StudentDto getStudentById(Long id);
    List<StudentDto> getAllStudent();
    StudentDto updateStudent(Long id, StudentDto studentDto);
    StudentDto patchStudent(Long theId, StudentDto theStudentDto);
    void deleteStudentById(Long theId);
}
