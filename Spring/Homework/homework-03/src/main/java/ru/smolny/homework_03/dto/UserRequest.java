package ru.smolny.homework_03.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class UserRequest {
    @NotBlank(message =  "Name is mandatory")
    String name;

    @NotBlank(message =  "Password is mandatory")
    String password;

    @NotBlank(message =  "Firstname is mandatory")
    String firstname;
}
