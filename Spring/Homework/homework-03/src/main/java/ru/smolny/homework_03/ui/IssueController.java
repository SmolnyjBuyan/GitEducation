package ru.smolny.homework_03.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.smolny.homework_03.service.IssueService;

@Controller
@RequiredArgsConstructor
@RequestMapping("ui/issue")
public class IssueController {
    private final IssueService issueService;

    @GetMapping
    private String getIssues(Model model) {
        model.addAttribute("issues", issueService.getAll());
        return "issues";
    }
}
