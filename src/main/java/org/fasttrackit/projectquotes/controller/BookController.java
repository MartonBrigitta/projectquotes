package org.fasttrackit.projectquotes.controller;

import lombok.AllArgsConstructor;
import org.fasttrackit.projectquotes.model.Book;
import org.fasttrackit.projectquotes.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

}
