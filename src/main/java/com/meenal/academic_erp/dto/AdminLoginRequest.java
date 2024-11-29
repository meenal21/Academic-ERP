package com.meenal.academic_erp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AdminLoginRequest(

    @NotNull(message = "Email cannot be null")
    @JsonProperty("email")
    @Email(message = "Enter a valid email")
    String email,

    @NotBlank(message= "Password cannot be null")
    @Size(min=6,max = 10)
    @JsonProperty("password")
    String password
    )
    {
}
