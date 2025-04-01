package ru.smolny.homework_03.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import ru.smolny.homework_03.service.BookService;

@Controller
@RequestMapping("/ui/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping()
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "books";
    }
}
