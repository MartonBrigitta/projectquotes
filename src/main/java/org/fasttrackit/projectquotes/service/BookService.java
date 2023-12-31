package org.fasttrackit.projectquotes.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.fasttrackit.projectquotes.exception.ResourceNotFoundException;
import org.fasttrackit.projectquotes.model.Book;
import org.fasttrackit.projectquotes.model.Quote;
import org.fasttrackit.projectquotes.model.Subject;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List <Book> getAllBooks(String title, String author) {
        return bookRepository.filterBooks(title,author);
    }


    public Book getById(long id){
        return bookRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("book not found", id));
    }

    public Book add(Book book) {
        bookRepository.save(book);
        return book;
    }

    public Book delete(long id){
        Book book = getById(id);
        bookRepository.deleteById(id);
        return book;
    }

    public Book update(Book book, long id) {
        Book existingBook = delete(id);
        return add(Book.builder()
                .id(id)
                .author(book.getAuthor())
                .title(book.getTitle())
                .build());
    }

    public Book addQuoteToBook(Long bookId, Quote quote) {
        Book book = getById(bookId);
        quote.setBook(book);
        book.getQuotes().add(quote);
        return bookRepository.save(book);
    }
}
