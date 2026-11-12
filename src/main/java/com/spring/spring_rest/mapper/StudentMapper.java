package com.spring.spring_rest.mapper;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;

/**
 * Converts between student entities and data transfer objects.
 */
public class StudentMapper {

    /**
     * Converts a student entity to a student data transfer object.
     *
     * @param theStudent entity to convert
     * @return a DTO containing the entity's student data
     */
    public static StudentDto mapToStudentDto(Student theStudent) {
        return new StudentDto(theStudent.getId(), 
                                theStudent.getFirstName(),
                                theStudent.getLastName(), 
                                theStudent.getEmail()
                            );
    }

    /**
     * Converts a student data transfer object to a student entity.
     *
     * @param thStudentDto DTO to convert
     * @return an entity containing the DTO's student data
     */
    public static Student mapToStudent(StudentDto thStudentDto) {
        return new Student(thStudentDto.getId(),
                            thStudentDto.getFirstName(),
                            thStudentDto.getLastName(),
                            thStudentDto.getEmail()
                        );
    }
}