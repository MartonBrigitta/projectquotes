package org.fasttrackit.projectquotes.controller;

import lombok.AllArgsConstructor;
import org.fasttrackit.projectquotes.model.Book;
import org.fasttrackit.projectquotes.model.Quote;
import org.fasttrackit.projectquotes.service.BookRepository;
import org.fasttrackit.projectquotes.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    @GetMapping
    public List<Book> getAll(@RequestParam(required = false)String title,
                             @RequestParam(required = false)String author) {
        return bookService.getAllBooks(title, author);
    }

    @GetMapping("/{id}") // GET http://host:port/books/2
    public Book getById(@PathVariable long id){
        return bookService.getById(id);
    }

    @PostMapping
    public Book addNewBook (@RequestBody Book book) {
        return bookService.add(book);
    }

    @PostMapping("/{id}/quotes")
    Book addQuoteToBook (@PathVariable Long id, @RequestBody Quote quote){
        return bookService.addQuoteToBook(id,quote);
    }

}
