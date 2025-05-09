package ru.smolny.homework_03.ui;

import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.smolny.homework_03.dto.IssueResponse;
import ru.smolny.homework_03.dto.ReaderResponse;
import ru.smolny.homework_03.mapper.ReaderMapper;
import ru.smolny.homework_03.model.User;
import ru.smolny.homework_03.service.ReaderService;

import java.util.List;

@Controller
@RequestMapping("/ui/reader")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderService readerService;
    private final ReaderMapper readerMapper;

    @GetMapping
    public String getReaders(Model model) {
        List<ReaderResponse> readers = readerMapper.toReaderResponseList(readerService.getAll());
        model.addAttribute("readers", readers);
        return "readers";
    }

    @GetMapping("/{id}")
    public String getReader(@PathVariable @Min(value = 1, message = "ID must be greater than 0") long id, Model model) {
        User reader = readerService.getById(id);
        List<IssueResponse> issues = readerService.getIssuesByReaderId(id);
        model.addAttribute("reader", reader);
        model.addAttribute("issues", issues);
        return "readerProfile";
    }
}
