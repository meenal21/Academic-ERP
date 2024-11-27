package com.meenal.academic_erp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Date;

@Builder
public record StudentResponse(
        @JsonProperty("rollNumber")
        String rollNumber,

        @JsonProperty("firstName")
        String firstName,

        @JsonProperty("lastName")
        String lastName,

        @JsonProperty("email")
        String email,

        @JsonProperty("cgpa")
        double cgpa,

        @JsonProperty("domain")
        String domain,

        @JsonProperty("photographPath")
        String photographPath,

        @JsonProperty("totalCredits")
        double totalCredits,

        @JsonProperty("graduationYear")
        Date graduationYear
){
}
