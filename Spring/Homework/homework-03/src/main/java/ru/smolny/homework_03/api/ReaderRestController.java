package ru.smolny.homework_03.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.smolny.homework_03.model.Issue;
import ru.smolny.homework_03.model.Reader;
import ru.smolny.homework_03.service.ReaderService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reader")
@Validated
public class ReaderRestController {
    private final ReaderService readerService;
    @GetMapping("/{id}")
    public ResponseEntity<Reader> getById(@PathVariable @Min(value = 1, message = "ID must be greater than 0") long id) {
        return ResponseEntity.ok(readerService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @Min(value = 1, message = "ID must be greater than 0") long id) {
        readerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Reader> create(@Valid @RequestBody ReaderRequest request, UriComponentsBuilder uriBuilder) {
        Reader reader = readerService.create(request.getName().trim());
        URI uri = uriBuilder.path("/reader/{id}").buildAndExpand(reader.getId()).toUri();
        return ResponseEntity.created(uri).body(reader);
    }

    @GetMapping("{id}/issue")
    public ResponseEntity<List<Issue>> getIssuesByReaderId
            (@PathVariable @Min(value = 1, message = "ID must be greater than 0") long id) {
        return ResponseEntity.ok(readerService.getIssuesByReaderId(id));
    }
}
