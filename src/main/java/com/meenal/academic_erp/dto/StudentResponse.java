package com.meenal.academic_erp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meenal.academic_erp.entity.Domain;
import com.meenal.academic_erp.entity.Placement;
import com.meenal.academic_erp.entity.Specialisation;
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

        @JsonProperty("photographPath")
        String photographPath,

        @JsonProperty("totalCredits")
        double totalCredits,

        @JsonProperty("graduationYear")
        String graduationYear,

        @JsonProperty("specialisation")
        Specialisation specialisation,

        @JsonProperty("domain")
        Domain domain,

        @JsonProperty("placement_id")
        Placement placement_id

){
}
