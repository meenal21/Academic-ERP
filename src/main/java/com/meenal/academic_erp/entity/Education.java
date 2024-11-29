package com.meenal.academic_erp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(
        name = "education",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id", "education_type"}) }
)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "education_type", nullable = false)
    private String educationType;

    @Column(name = "percentage")
    private String percentage;

    @Column(name = "year")
    private String year;

    @Column(name = "school_name")
    private String schoolName;

    // Many-to-One relationship to Students
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    private Students student;
}
