package com.meenal.academic_erp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record AdminResponse (
    @JsonProperty("email")
    String email,

    @JsonProperty("userName")
    String userName,

    @JsonProperty("password")
    String password
    )
{}
