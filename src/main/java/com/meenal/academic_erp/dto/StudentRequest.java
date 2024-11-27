package com.meenal.academic_erp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record StudentRequest(
        @NotBlank(message="Roll Number cannot be blank")
        @JsonProperty("rollNumber")
        String rollNumber,

        @NotBlank(message="First Name cannot be blank")
        @JsonProperty("firstName")
        String firstName,

        @NotBlank(message = "Last Name cannot be blank")
        @JsonProperty("last_name")
        String lastName,

        @NotBlank(message = "Email is required")
        @Email(message="Email must be in correct format")
        @JsonProperty("email")
        String email,

        @JsonProperty("cgpa")
        double cgpa,

        @JsonProperty("photograph_path")
        String photographPath,

        @JsonProperty("domain")
        String domain,

        @JsonProperty("totalCredits")
        double totalCredits,

        @JsonProperty("graduationYear")
        Date graduationYear
) {
}
