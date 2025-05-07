package ru.smolny.homework_03.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.smolny.homework_03.dto.IssueResponse;
import ru.smolny.homework_03.dto.UserRequest;
import ru.smolny.homework_03.dto.ReaderResponse;
import ru.smolny.homework_03.exception.*;
import ru.smolny.homework_03.mapper.ReaderMapper;
import ru.smolny.homework_03.model.User;
import ru.smolny.homework_03.service.ReaderService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reader")
@Tag(name = "Reader")
@Validated
public class ReaderRestController {
    private final ReaderService readerService;
    private final ReaderMapper readerMapper;

    @GetMapping("/{id}")
    @Operation(summary = "get reader by id", description = "Получить данные о читателе по его ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Читатель успешно найден",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ReaderResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка валидации (некорректный ID)",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "Читатель не найден",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
            )}
    )
    public ResponseEntity<ReaderResponse> getById(@PathVariable @Min(value = 1) long id) {
        User reader = readerService.getById(id);
        ReaderResponse response = readerMapper.toReaderResponse(reader);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Читатель успешно удален"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка валидации (некорректный ID)",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
            )}
    )
    @Operation(summary = "delete reader by id", description = "Удалить читателя по его ID")
    public ResponseEntity<Void> deleteById(@PathVariable @Min(value = 1) long id) {
        readerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @Operation(summary = "create reader", description = "Добавить нового читателя в систему")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Читатель успешно добавлен",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ReaderResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка валидации (некорректное имя)",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)
                    ))
    })
    public ResponseEntity<ReaderResponse> create(
            @Valid @RequestBody UserRequest request, UriComponentsBuilder uriBuilder) {
        User reader = readerService.create(request);
        ReaderResponse response = readerMapper.toReaderResponse(reader);
        URI uri = uriBuilder.path("/reader/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("{id}/issue")
    @Operation(summary = "get issues by reader id", description = "Получить все актуальные выдачи книг читателю по его ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Список выдач книг читателю успешно найден",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = IssueResponse.class, type = "array"))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка валидации (некорректный ID)",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "Читатель не найден",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
            )}
    )
    public ResponseEntity<List<IssueResponse>> getIssuesByReaderId(@PathVariable @Min(value = 1) long id) {
        return ResponseEntity.ok(readerService.getIssuesByReaderId(id));
    }

    @GetMapping
    @Operation(summary = "get readers", description = "Получить всех читателей")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Список читателей успешно найден",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = IssueResponse.class, type = "array")))
    })
    public ResponseEntity<List<ReaderResponse>> getAll() {
        List<ReaderResponse> response = readerMapper.toReaderResponseList(readerService.getAll());
        return ResponseEntity.ok(response);
    }

}
