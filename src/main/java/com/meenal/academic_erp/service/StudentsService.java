package com.meenal.academic_erp.service;

import com.meenal.academic_erp.dto.StudentsRequest;
import com.meenal.academic_erp.dto.StudentsResponse;
import com.meenal.academic_erp.entity.Students;
import com.meenal.academic_erp.mapper.StudentsMapper;
import com.meenal.academic_erp.repo.StudentsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentsService {

    private final StudentsRepo repo;
    //for the custom queries and fetching data from the database
    private final StudentsMapper mapper;

    public String createStudent(StudentsRequest req) {
        Students studentsList = mapper.toStudents(req);
        repo.save(studentsList);
        return "created";
    }

    public StudentsResponse getStudents(String rollNumber) {
        Students student = repo.findStudentsByRollNumber(rollNumber);
        StudentsResponse resp = new StudentsResponse(student.getRollNumber(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getCgpa(), student.getDomain(), student.getPhotographPath(), student.getTotalCredits(), student.getGraduationYear());
        return resp;
    }
}
