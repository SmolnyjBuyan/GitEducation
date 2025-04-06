package ru.smolny.homework_03.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class ReaderRequest {
    @NotBlank(message =  "Name is mandatory")
    String name;
}
