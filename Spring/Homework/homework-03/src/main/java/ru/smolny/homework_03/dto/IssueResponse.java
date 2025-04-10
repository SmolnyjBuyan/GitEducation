package ru.smolny.homework_03.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Value
@Schema(name = "Выдача-Ответ")
public class IssueResponse {
    private static final DateTimeFormatter RU_FORMATTER = DateTimeFormatter.ofPattern(
            "d MMMM yyyy 'г.' HH:mm:ss", new Locale("ru"));

    @Schema(name = "Идентификатор")
    @Min(1)
    long id;
    @Schema(name = "Идентификатор книги")
    @Min(1)
    long bookId;
    @Schema(name = "Название книги")
    @NotBlank
    String bookTitle;
    @Schema(name = "Идентификатор читателя")
    @Min(1)
    long readerId;
    @Schema(name = "Имя читателя")
    @NotBlank
    String readerName;
    @Schema(name = "Дата выдачи")
    @PastOrPresent
    LocalDateTime issueDate;
    @Schema(name = "Дата возврата")
    @PastOrPresent
    LocalDateTime returnDate;

    @JsonIgnore
    public String getFormattedIssueDate() {
        return RU_FORMATTER.format(issueDate);
    }

    @JsonIgnore
    public String getFormattedReturnDate() {
        return returnDate != null ? RU_FORMATTER.format(returnDate) : null;
    }
}
