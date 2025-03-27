package ru.smolny.homework_03.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.smolny.homework_03.model.Issue;
import ru.smolny.homework_03.service.IssueService;

import java.net.URI;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/issue")
public class IssueController {
    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request, UriComponentsBuilder uriBuilder) {
        log.info("Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());
        Issue issue;
        try {
            issue = issueService.issue(request);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }

        URI uri = uriBuilder.path("/issue/{id}").buildAndExpand(issue.getId()).toUri();
        return ResponseEntity.created(uri).body(issue);
    }
}
