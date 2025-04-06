package ru.smolny.homework_03.dto;

import jakarta.validation.constraints.Min;
import lombok.Value;

@Value
public class IssueRequest {
    @Min(value = 1)
    long readerId;
    @Min(value = 1)
    long bookId;
}
