package com.spring.spring_rest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.StudentNotFoundException;

/**
 * Implements student operations using the student repository.
 */
@Service
public class StudentServiceImplement implements StudentService{

    private StudentRepository studentRepo;

    /**
     * Creates the service with its student repository dependency.
     *
     * @param studentRepo repository used to access student records
     */
    public StudentServiceImplement(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public StudentDto createStudent(StudentDto theStudentDto) {
        Student theStudent = StudentMapper.mapToStudent(theStudentDto);
        Student saved = studentRepo.save(theStudent);

        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public StudentDto getStudentById(Long theId) {
        Student student = studentRepo.findById(theId)
        .orElseThrow(() ->
                new StudentNotFoundException("Student id: " + theId +
                    " not found!")
        );
        
        return StudentMapper.mapToStudentDto(student);
    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepo.findAll();
        return students.stream().map(
            (student) -> StudentMapper.mapToStudentDto(student)
        ).collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student student = studentRepo.findById(id)
            .orElseThrow(() -> new StudentNotFoundException(
                "Student id " + id + " not found!"
            ));
        
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * {@inheritDoc}
     */
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
            student.setEmail(theStudentDto.getEmail());
        }

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * {@inheritDoc}
     */
    @Override 
    public void deleteStudentById(Long theId) {
        studentRepo.findById(theId)
            .orElseThrow(() -> new StudentNotFoundException(
                "Student id " + theId + " not found!"
            ));

        studentRepo.deleteById(theId);
    }

}   
