package com.meenal.academic_erp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "placement")
public class Placement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "organisation", nullable = false)
    private String organisation;

    @Column(name= "profile")
    private String profile;

    @Column(name = "description")
    private String description;

    @Column(name = "intake")
    private int intake;

    @Column(name = "minimum_grade")
    private double minimumGrade;

}
