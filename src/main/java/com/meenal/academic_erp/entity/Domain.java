package com.meenal.academic_erp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="domain")
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long domain_id;

    @Column(name = "program", nullable= false)
    private String program;

    @Column(name = "batch", nullable=false)
    private String batch;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "qualification", nullable = false)
    private String qualification;
}
