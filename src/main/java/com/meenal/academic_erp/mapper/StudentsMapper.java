package com.meenal.academic_erp.mapper;

import com.meenal.academic_erp.dto.StudentsRequest;
import com.meenal.academic_erp.entity.Students;

public class StudentsMapper {

    public Students toStudents(StudentsRequest req) {
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

}
