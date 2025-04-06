package ru.smolny.homework_03.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class BookRequest {
    @NotBlank(message =  "Title is mandatory")
    String title;
}
