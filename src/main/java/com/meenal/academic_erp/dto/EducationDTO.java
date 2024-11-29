package com.meenal.academic_erp.dto;

import com.meenal.academic_erp.entity.Students;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

public record EducationDTO(
    @NotBlank(message = "Education Type must be present")
    String educationType,

    @NotBlank(message = "Percentage must be given")
    String percentage,

    @NotBlank(message = "Year Must be present")
    String year,

    @NotBlank(message = "School Name must be present")
    String schoolName
) {
}
