package ru.smolny.homework_03.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class UserRequest {
    @NotBlank(message =  "Name is mandatory")
    String username;

    @NotBlank(message =  "Password is mandatory")
    String password;

    @NotBlank(message =  "Firstname is mandatory")
    String firstname;
}
