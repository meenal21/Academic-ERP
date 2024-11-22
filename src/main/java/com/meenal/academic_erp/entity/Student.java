package com.meenal.academic_erp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="student_id")
    private int studentId;

    @Column(name= "roll_number", nullable = false, unique = true)
    private String rollNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "photograph_path")
    private String photographPath;

    @Column(name = "cgpa")
    private double cgpa;

    @Column(name = "domain")
    private String domain;

    @Column(name = "total_credits")
    private float totalCredits;

    @Column(name = "graduation_year")
    private Date graduationYear;



}
