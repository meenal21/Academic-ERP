package com.meenal.academic_erp.entity;

import jakarta.persistence.*;
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
public class Students {

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

    @Column(name = "total_credits")
    private double totalCredits;

    @Column(name = "graduation_year")
    private String graduationYear;

    @ManyToOne(optional = true)
    @JoinColumn(name = "domain", nullable = true, referencedColumnName = "domain_id", foreignKey = @ForeignKey(name = "FK_studentDomain"))
    private Domain domain;

    // Relationship to Specialisation
    @ManyToOne(optional = false)
    @JoinColumn(name = "specialisation", nullable = true, referencedColumnName = "specialisation_id", foreignKey = @ForeignKey(name = "FK_studentSpecialisation"))
    private Specialisation specialisation;

    // Relationship to Placement
    @ManyToOne(optional = true)
    @JoinColumn(name = "placement_id", nullable = true, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_studentPlacement"))
    private Placement placement;
}
