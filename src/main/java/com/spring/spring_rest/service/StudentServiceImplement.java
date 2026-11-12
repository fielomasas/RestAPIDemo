package com.spring.spring_rest.service;

import com.spring.spring_rest.controller.DemoRestController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;

import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.AlreadyExistingEmailException;
import com.spring.spring_rest.exception.StudentNotFoundException;

@Service
public class StudentServiceImplement implements StudentService{
    
    private StudentRepository studentRepo;

    public StudentServiceImplement(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override 
    public StudentDto createStudent(StudentDto theStudentDto) {
        if(studentRepo.existsByEmail(theStudentDto.getEmail())) {
            throw new AlreadyExistingEmailException(
                "Email already exists."
            );
        }

        Student theStudent = StudentMapper.mapToStudent(theStudentDto);
        Student saved = studentRepo.save(theStudent);

        return StudentMapper.mapToStudentDto(saved);
    }

    @Override 
    public StudentDto getStudentById(Long theId) {
        Student student = studentRepo.findById(theId)
        .orElseThrow(() ->
                new StudentNotFoundException("Student id: " + theId +
                    " not found!")
        );
        
        return StudentMapper.mapToStudentDto(student);
    }

    @Override 
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepo.findAll();
        return students.stream().map(
            (student) -> StudentMapper.mapToStudentDto(student)
        ).collect(Collectors.toList());
    }

    @Override 
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student student = studentRepo.findById(id)
            .orElseThrow(() -> new StudentNotFoundException(
                "Student id " + id + " not found!"
            ));
        
        if (studentRepo.existsByEmailAndIdNot(studentDto.getEmail(), id)) {
            throw new AlreadyExistingEmailException(
                "Email already exists."
            );
        }
        
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(student.getLastName());
        student.setEmail(studentDto.getEmail());

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    @Override 
    public StudentDto patchStudent(Long theId, StudentDto theStudentDto) {
        Student student = studentRepo.findById(theId)
            .orElseThrow(() -> new StudentNotFoundException(
                "Student id " + theId + " not found!"
            ));
        
        
        
        if(theStudentDto.getFirstName() != null) {
            student.setFirstName(theStudentDto.getFirstName());
        }
        if(theStudentDto.getLastName() != null) {
            student.setLastName(theStudentDto.getLastName());
        }
        if(theStudentDto.getEmail() != null) {
            if (studentRepo.existsByEmailAndIdNot(theStudentDto.getEmail(), theId)) {
                throw new AlreadyExistingEmailException(
                    "Email already exists."
                );
            }

            student.setEmail(theStudentDto.getEmail());
        }

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    @Override 
    public void deleteStudentById(Long theId) {
        studentRepo.findById(theId)
            .orElseThrow(() -> new StudentNotFoundException(
                "Student id " + theId + " not found!"
            ));

        studentRepo.deleteById(theId);
    }

}   
