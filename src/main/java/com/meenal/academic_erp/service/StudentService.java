package com.meenal.academic_erp.service;

import com.meenal.academic_erp.dto.StudentResponse;
import com.meenal.academic_erp.dto.StudentRequest;
import com.meenal.academic_erp.entity.Domain;
import com.meenal.academic_erp.entity.Placement;
import com.meenal.academic_erp.entity.Specialisation;
import com.meenal.academic_erp.entity.Students;
import com.meenal.academic_erp.helper.JWTHelper;
import com.meenal.academic_erp.mapper.EducationMapper;
import com.meenal.academic_erp.mapper.StudentMapper;
import com.meenal.academic_erp.repo.DomainRepo;
import com.meenal.academic_erp.repo.PlacementRepo;
import com.meenal.academic_erp.repo.SpecialisationRepo;
import com.meenal.academic_erp.repo.StudentsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final EducationMapper educationMapper;
    private final StudentsRepo repo;
    private final DomainRepo domainRepo;
    private final SpecialisationRepo specialisationRepo;
    private final PlacementRepo placementRepo;
    //for the custom queries and fetching data from the database
    private final JWTHelper jwtHelper;
    private final PasswordEncoder passwordEncoder;
    private final StudentMapper mapper;
    private final StudentMapper studentMapper;

    public boolean validateToken(String auth_token) {
        //since the token comes in the form of Bearer way - so need to extract the substring and then get the next part
        String token =auth_token.substring(7);
        return jwtHelper.validateToken(token);
    }


    public String createStudent(StudentRequest req) {
        Domain domain  = domainRepo.findById(req.domain().getDomain_id()).orElse(null);
        Specialisation specialisation = specialisationRepo.findById(req.specialisation().getSpecialisation_id()).orElse(null);
        Placement placement = placementRepo.findById(req.placement().getId()).orElse(null);
        Students studentsList = mapper.toStudents(req, domain, placement, specialisation);
        repo.save(studentsList);
        return "created";
    }

    public StudentResponse getStudents(String email) {
        Students student = repo.findStudentsByEmail(email);
        StudentResponse resp = new StudentResponse(
                student.getRollNumber(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getCgpa(),
                student.getPhotographPath(),
                student.getTotalCredits(),
                student.getGraduationYear(),
                student.getSpecialisation(),
                student.getDomain(),
                student.getPlacement(),
                educationMapper.toEducationDTOList(student.getEducationList())
                );
        return resp;
    }

    // new function - getAllStudents -
    //new mapper created - toStudentsResponse

    public List<StudentResponse> getAllStudents() {
        List<Students> students = repo.findAll();
        return mapper.toStudentResponseList(students);
    }

    public String updateStudent(StudentRequest req) {
        Students student = repo.findStudentsByEmail(req.email());
        student.setEmail(req.email());
        student.setFirstName(req.firstName());
        student.setLastName(req.lastName());
        student.setCgpa(req.cgpa());
        student.setDomain(req.domain());
        student.setPhotographPath(req.photographPath());
        student.setTotalCredits(req.totalCredits());
        student.setGraduationYear(req.graduationYear());
        student.setSpecialisation(req.specialisation());
        student.setPlacement(req.placement());
        student.setDomain(req.domain());
        student.setEducationList(educationMapper.toEducationList(req.educationDTOList()));
        repo.save(student);
        return "updated";
    }


}
