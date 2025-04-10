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
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.smolny.homework_03.dto.IssueRequest;
import ru.smolny.homework_03.dto.IssueResponse;
import ru.smolny.homework_03.dto.ReaderResponse;
import ru.smolny.homework_03.exception.ErrorResponse;
import ru.smolny.homework_03.service.IssueService;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/api/issue")
@Tag(name = "Issue")
@RequiredArgsConstructor
@Validated
public class IssueRestController {
    private final IssueService issueService;

    @GetMapping("/{id}")
    @Operation(summary = "get issue by id", description = "Получить данные о выдаче по ее ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Выдача успешна найдена",
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
                    description = "Выдача не найдена",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    public ResponseEntity<IssueResponse> getById(@PathVariable @Min(value = 1) long id) {
        return ResponseEntity.ok(issueService.getById(id));
    }

    @PostMapping
    @Operation(summary = "issue a book", description = "Выдать книгу по ее ID читателю по его ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Книга успешна выдана",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = IssueResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка валидации (некорректный ID)",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "Книга или пользователь не найдены",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Предел книг на руки или запрашиваемая книга уже на руках",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    public ResponseEntity<IssueResponse> issueBook(@RequestBody @Valid IssueRequest request, UriComponentsBuilder uriBuilder) {
        IssueResponse issue = issueService.issue(request);
        URI uri = uriBuilder.path("/issue/{id}").buildAndExpand(issue.getId()).toUri();
        return ResponseEntity.created(uri).body(issue);
    }

    @PutMapping("{id}")
    @Operation(summary = "return a book", description = "Вернуть книгу по ID выдачи")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Книга возвращена",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = IssueResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка валидации (некорректный ID)",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "Выдача не найдена",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    public ResponseEntity<IssueResponse> returnBook(@PathVariable @Min(value = 1) long id) {
        return ResponseEntity.ok(issueService.returnBook(id));
    }
}
