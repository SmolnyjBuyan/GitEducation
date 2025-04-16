package ru.smolny.homework_03.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
@Schema(name = "Читатель-Запрос")
public class ReaderRequest {
    @Schema(name = "Имя")
    @NotBlank(message =  "Name is mandatory")
    String name;

    @Schema(name = "Пароль")
    @NotBlank(message =  "Password is mandatory")
    String password;
}
