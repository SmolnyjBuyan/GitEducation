package ru.smolny.homework_03.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Ошибка-Ответ")
public class ErrorResponse {
    @Schema(name = "Название")
    private final String title;
    @Schema(name = "Сообщение")
    private final String message;
}
