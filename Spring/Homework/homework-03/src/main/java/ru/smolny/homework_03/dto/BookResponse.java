package ru.smolny.homework_03.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
@Schema(name = "Книга-Ответ")
public class BookResponse {
    @Schema(name = "Идентификатор")
    @Min(1)
    long id;
    @Schema(name = "Название")
    @NotBlank
    String title;
}
