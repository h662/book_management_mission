package com.h662.book_management_mission.controller;

import com.h662.book_management_mission.model.Book;
import com.h662.book_management_mission.repository.AuthorRepository;
import com.h662.book_management_mission.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }

    @GetMapping("/books/new")
    public String form(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorRepository.finalAll());

        return "book_form";
    }

    @PostMapping("/books")
    public String save(@ModelAttribute Book book) {
        bookRepository.save(book);

        return "redirect:/";
    }
}
