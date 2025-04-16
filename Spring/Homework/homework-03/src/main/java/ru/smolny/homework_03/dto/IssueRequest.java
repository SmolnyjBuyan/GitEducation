package ru.smolny.homework_03.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Value;

@Value
@Schema(name = "Выдача-Запрос")
public class IssueRequest {
    @Min(value = 1)
    long readerId;
    @Min(value = 1)
    long bookId;
}
