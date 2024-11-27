package com.meenal.academic_erp.controller;

import com.meenal.academic_erp.dto.StudentResponse;
import com.meenal.academic_erp.dto.StudentRequest;
import com.meenal.academic_erp.service.StudentsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentsController {

    private final StudentsService studentsService;

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody @Valid StudentRequest req){
        return ResponseEntity.ok(studentsService.createStudent(req));
    }

    @GetMapping("/{email}")
    public ResponseEntity<StudentResponse> getStudents(@PathVariable("email") String email){
        return ResponseEntity.ok(studentsService.getStudents(email));
    }

    //responseentity - gets back the response from the server and sends to the frontend - or the api caller
    @GetMapping
    //return type to be?
    //returning list of student responses
    public ResponseEntity<List<StudentResponse>> getAllStudents(){
        return ResponseEntity.ok(studentsService.getAllStudents());
    }
}
