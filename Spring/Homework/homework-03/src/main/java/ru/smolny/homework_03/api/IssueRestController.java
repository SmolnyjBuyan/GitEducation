package ru.smolny.homework_03.api;

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
import ru.smolny.homework_03.service.IssueService;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/api/issue")
@RequiredArgsConstructor
@Validated
public class IssueRestController {
    private final IssueService issueService;

    @GetMapping("/{id}")
    public ResponseEntity<IssueResponse> getById(@PathVariable @Min(value = 1) long id) {
        return ResponseEntity.ok(issueService.getById(id));
    }

    @PostMapping
    public ResponseEntity<IssueResponse> issueBook(@RequestBody @Valid IssueRequest request, UriComponentsBuilder uriBuilder) {
        IssueResponse issue = issueService.issue(request);
        URI uri = uriBuilder.path("/issue/{id}").buildAndExpand(issue.getId()).toUri();
        return ResponseEntity.created(uri).body(issue);
    }

    @PutMapping("{id}")
    public ResponseEntity<IssueResponse> returnBook(@PathVariable @Min(value = 1) long id) {
        return ResponseEntity.ok(issueService.returnBook(id));
    }
}
