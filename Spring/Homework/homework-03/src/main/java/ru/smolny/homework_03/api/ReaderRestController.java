package ru.smolny.homework_03.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.smolny.homework_03.dto.IssueResponse;
import ru.smolny.homework_03.dto.ReaderRequest;
import ru.smolny.homework_03.dto.ReaderResponse;
import ru.smolny.homework_03.model.Issue;
import ru.smolny.homework_03.model.Reader;
import ru.smolny.homework_03.service.ReaderService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reader")
@Validated
public class ReaderRestController {
    private final ReaderService readerService;
    @GetMapping("/{id}")
    public ResponseEntity<ReaderResponse> getById(@PathVariable @Min(value = 1) long id) {
        return ResponseEntity.ok(readerService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @Min(value = 1) long id) {
        readerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ReaderResponse> create(
            @Valid @RequestBody ReaderRequest request, UriComponentsBuilder uriBuilder) {
        ReaderResponse readerResponse = readerService.create(request.getName().trim());
        URI uri = uriBuilder.path("/reader/{id}").buildAndExpand(readerResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(readerResponse);
    }

    @GetMapping("{id}/issue")
    public ResponseEntity<List<IssueResponse>> getIssuesByReaderId(@PathVariable @Min(value = 1) long id) {
        return ResponseEntity.ok(readerService.getIssuesByReaderId(id));
    }
}
