package com.meenal.academic_erp.service;

import com.meenal.academic_erp.dto.StudentResponse;
import com.meenal.academic_erp.dto.StudentRequest;
import com.meenal.academic_erp.entity.Students;
import com.meenal.academic_erp.helper.JWTHelper;
import com.meenal.academic_erp.mapper.StudentMapper;
import com.meenal.academic_erp.repo.StudentsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentsRepo repo;
    //for the custom queries and fetching data from the database
    private final JWTHelper jwtHelper;
    private final PasswordEncoder passwordEncoder;
    private final StudentMapper mapper;

    public boolean validateToken(String auth_token) {
        //since the token comes in the form of Bearer way - so need to extract the substring and then get the next part
        String token =auth_token.substring(7);
        return jwtHelper.validateToken(token);
    }


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
    /*
    public String updateStudent(StudentRequest req) {
        // I have studentrequest and I have to fetch student using email
        //
        // }

     */
}
