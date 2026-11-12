package com.spring.spring_rest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.AlreadyExistingEmailException;
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
     * Creates a student after checking that the email is not already in use.
     *
     * @param theStudentDto data for the student to create
     * @return the created student
     * @throws AlreadyExistingEmailException if another student uses the email
     */
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

    /**
     * Retrieves a student by ID.
     *
     * @param theId ID of the student to retrieve
     * @return the requested student
     * @throws StudentNotFoundException if no student has the given ID
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
     * Retrieves all students.
     *
     * @return all students
     */
    @Override 
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepo.findAll();
        return students.stream().map(
            (student) -> StudentMapper.mapToStudentDto(student)
        ).collect(Collectors.toList());
    }

    /**
     * Replaces a student's data after 
     * checking the email is not used by another student.
     *
     * @param id ID of the student to update
     * @param studentDto replacement student data
     * @return the updated student
     * @throws StudentNotFoundException if no student has the given ID
     * @throws AlreadyExistingEmailException if another student uses the email
     */
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
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * Updates the provided non-null fields of a student.
     *
     * @param theId ID of the student to update
     * @param theStudentDto student fields to update
     * @return the updated student
     * @throws StudentNotFoundException if no student has the given ID
     * @throws AlreadyExistingEmailException if another 
     * student uses the supplied email
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
            if (studentRepo.existsByEmailAndIdNot(theStudentDto.getEmail(), 
                                                    theId)) {
                throw new AlreadyExistingEmailException(
                    "Email already exists."
                );
            }

            student.setEmail(theStudentDto.getEmail());
        }

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * Deletes a student by ID.
     *
     * @param theId ID of the student to delete
     * @throws StudentNotFoundException if no student has the given ID
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
