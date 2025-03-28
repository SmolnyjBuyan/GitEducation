package ru.smolny.homework_03.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookRequest {
    @NotBlank(message =  "Title is mandatory")
    private final String title;
}
