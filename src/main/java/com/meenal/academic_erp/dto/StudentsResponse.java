package com.meenal.academic_erp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record StudentsResponse(
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
