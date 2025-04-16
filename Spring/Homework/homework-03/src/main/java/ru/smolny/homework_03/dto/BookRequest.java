package ru.smolny.homework_03.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
@Schema(name = "Книга-Запрос")
public class BookRequest {
    @NotBlank(message =  "Title is mandatory")
    String title;
}
