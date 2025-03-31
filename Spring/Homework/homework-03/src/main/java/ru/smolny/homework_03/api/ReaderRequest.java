package ru.smolny.homework_03.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReaderRequest {
    @NotBlank(message =  "Name is mandatory")
    private final String name;
}
