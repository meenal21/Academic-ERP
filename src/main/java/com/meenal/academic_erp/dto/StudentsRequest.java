package com.meenal.academic_erp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record StudentsRequest(
        @NotBlank(message="First Name cannot be blank")
        @JsonProperty("firstName")
        String firstName,

        @NotBlank(message = "Last Name cannot be blank")
        @JsonProperty("lastName")
        String lastName,

        @NotBlank(message = "Email is required")
        @Email(message="Email must be in correct format")
        @JsonProperty("email")
        String email,

        @JsonProperty("cgpa")
        double cgpa,

        @JsonProperty("photographPath")
        String photographPath,

        @JsonProperty("domain")
        String domain,

        @JsonProperty("totalCredits")
        double totalCredits,

        @JsonProperty("graduationYear")
        Date graduationYear
) {
}
