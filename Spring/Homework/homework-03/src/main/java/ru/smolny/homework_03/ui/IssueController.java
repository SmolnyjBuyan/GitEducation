package ru.smolny.homework_03.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.smolny.homework_03.dto.IssueResponse;
import ru.smolny.homework_03.mapper.IssueMapper;
import ru.smolny.homework_03.service.IssueService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("ui/issue")
public class IssueController {
    private final IssueService issueService;
    private final IssueMapper issueMapper;

    @GetMapping
    private String getIssues(Model model) {
        List<IssueResponse> issues = issueMapper.toIssueResponseList(issueService.getAll());
        model.addAttribute("issues", issues);
        return "issues";
    }
}
