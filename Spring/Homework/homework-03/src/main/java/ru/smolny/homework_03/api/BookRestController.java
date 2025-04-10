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
import ru.smolny.homework_03.dto.BookRequest;
import ru.smolny.homework_03.dto.BookResponse;
import ru.smolny.homework_03.dto.ReaderResponse;
import ru.smolny.homework_03.exception.ErrorResponse;
import ru.smolny.homework_03.service.BookService;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/book")
@Tag(name = "Book")
@Validated
public class BookRestController {
    private final BookService bookService;

    @GetMapping("/{id}")
    @Operation(summary = "get book by id", description = "Получить данные о книге по ее ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Книга успешна найдена",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BookResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка валидации (некорректный ID)",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "Книга не найдена",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    public ResponseEntity<BookResponse> getById(@PathVariable @Min(value = 1) long id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete book by id", description = "Удалить книгу по ее ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Книга успешно удалена"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка валидации (некорректный ID)",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    public ResponseEntity<Void> deleteById(@PathVariable @Min(value = 1) long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @Operation(summary = "create book", description = "Добавить новую книгу в систему")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Книга успешно добавлена",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = BookResponse.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка валидации (неккоректное название)",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)
                    )),
            @ApiResponse(
                    responseCode = "409",
                    description = "Книга уже существует",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)
                    ))
    })
    public ResponseEntity<BookResponse> create(
            @Valid @RequestBody BookRequest request, UriComponentsBuilder uriBuilder) {
        BookResponse bookResponse = bookService.create(request.getTitle().trim());
        URI uri = uriBuilder.path("/book/{id}").buildAndExpand(bookResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(bookResponse);
    }
}
