package com.meenal.academic_erp.controller;

import com.meenal.academic_erp.dto.StudentResponse;
import com.meenal.academic_erp.dto.StudentRequest;
import com.meenal.academic_erp.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentsController {

    private final StudentService studentService;

    // do I want the auth during creating a student?

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody @Valid StudentRequest req){
        return ResponseEntity.ok(studentService.createStudent(req));
    }

    // yes here I need the token!!!
    @GetMapping("/{email}")
    public ResponseEntity<StudentResponse> getStudents(@PathVariable("email") String email){
        return ResponseEntity.ok(studentService.getStudents(email));
    }

    //responseentity - gets back the response from the server and sends to the frontend - or the api caller
    @GetMapping
    //return type to be?
    //returning list of student responses
    public ResponseEntity<List<StudentResponse>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody @Valid StudentRequest req){
        return ResponseEntity.ok(studentService.updateStudent(req));
    }

}
