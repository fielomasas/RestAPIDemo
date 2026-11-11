package com.spring.spring_rest.service;

import org.springframework.stereotype.Service;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;
import com.spring.spring_rest.entity.Student;

@Service
public class StudentServiceImplement implements StudentService{
    
    private StudentRepository studentRepo;

    public StudentServiceImplement(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override 
    public StudentDto createStudent(StudentDto theStudentDto) {
        Student theStudent = StudentMapper.mapToStudent(theStudentDto);
        Student saved = studentRepo.save(theStudent);

        return StudentMapper.mapToStudentDto(saved);
    }
}   
