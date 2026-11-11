package com.spring.spring_rest.mapper;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;

public class StudentMapper {

    // Method that will map Student to StudentDto
    public static StudentDto mapToStudentDto(Student theStudent) {
        return new StudentDto(theStudent.getId(), 
                                theStudent.getFirstName(),
                                theStudent.getLastName(), 
                                theStudent.getEmail()
                            );
    }

    // Method that will map StudentDto to Student
    public static Student mapToStudent(StudentDto thStudentDto) {
        return new Student(thStudentDto.getId(),
                            thStudentDto.getFirstName(),
                            thStudentDto.getLastName(),
                            thStudentDto.getEmail()
                        );
    }
}
