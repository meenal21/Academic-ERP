package com.meenal.academic_erp.mapper;

import com.meenal.academic_erp.dto.StudentResponse;
import com.meenal.academic_erp.dto.StudentRequest;
import com.meenal.academic_erp.entity.Students;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentsMapper {

    //in studentRequest - we can directly get any element using named function to get the data
    public Students toStudents(StudentRequest req) {
        return Students.builder()
                .rollNumber(req.rollNumber())
                .firstName(req.firstName())
                .lastName(req.lastName())
                .email(req.email())
                .cgpa(req.cgpa())
                .domain(req.domain())
                .photographPath(req.photographPath())
                .totalCredits(req.totalCredits())
                .graduationYear(req.graduationYear())
                .build();
    }

    //can use any return type - when you want to map from one entity to another
    //in Students - need to get the data using getter method
    //for each student to response
    public StudentResponse toStudentsResponse(Students students) {
        return StudentResponse.builder()
                .rollNumber(students.getRollNumber())
                .email(students.getEmail())
                .firstName(students.getFirstName())
                .lastName(students.getLastName())
                .build();
    }

    //returns a list of student responses which are converted from students list
    //response - here is list!
    //for loop for converting each student to student response and then adding to the list of studentresponse
    public List<StudentResponse> toStudentResponseList(List<Students> students) {
        List<StudentResponse> response= new ArrayList<>();
        for (Students student : students) {
            response.add(toStudentsResponse(student));
        }

        return response;
    }
}
