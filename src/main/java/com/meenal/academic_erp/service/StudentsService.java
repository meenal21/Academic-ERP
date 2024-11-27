package com.meenal.academic_erp.service;

import com.meenal.academic_erp.dto.StudentResponse;
import com.meenal.academic_erp.dto.StudentRequest;
import com.meenal.academic_erp.entity.Students;
import com.meenal.academic_erp.mapper.StudentsMapper;
import com.meenal.academic_erp.repo.StudentsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentsService {

    private final StudentsRepo repo;
    //for the custom queries and fetching data from the database
    private final StudentsMapper mapper;

    public String createStudent(StudentRequest req) {
        Students studentsList = mapper.toStudents(req);
        repo.save(studentsList);
        return "created";
    }

    public StudentResponse getStudents(String rollNumber) {
        Students student = repo.findStudentsByRollNumber(rollNumber);
        StudentResponse resp = new StudentResponse(student.getRollNumber(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getCgpa(), student.getDomain(), student.getPhotographPath(), student.getTotalCredits(), student.getGraduationYear());
        return resp;
    }

    // new function - getAllStudents -
    //new mapper created - toStudentsResponse

    public List<StudentResponse> getAllStudents() {
        return mapper.toStudentResponseList(repo.findAll());
    }
}
