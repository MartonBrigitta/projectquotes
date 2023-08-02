package org.fasttrackit.projectquotes.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.fasttrackit.projectquotes.model.Book;
import org.fasttrackit.projectquotes.model.Quote;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List <Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
