package ru.smolny.homework_03.api;

import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.smolny.homework_03.model.Issue;
import ru.smolny.homework_03.service.IssueService;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/issue")
@RequiredArgsConstructor
@Validated
public class IssueRestController {
    private final IssueService issueService;

    @GetMapping("/{id}")
    public ResponseEntity<Issue> getById(@PathVariable @Min(value = 1, message = "ID must be greater than 0") long id) {
        return ResponseEntity.ok(issueService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request, UriComponentsBuilder uriBuilder) {
        Issue issue = issueService.issue(request);
        URI uri = uriBuilder.path("/issue/{id}").buildAndExpand(issue.getId()).toUri();
        return ResponseEntity.created(uri).body(issue);
    }

    @PutMapping("{id}")
    public ResponseEntity<Issue> returnBook
            (@PathVariable @Min(value = 1, message = "ID must be greater than 0") long id) {
        return ResponseEntity.ok(issueService.returnBook(id));
    }
}
