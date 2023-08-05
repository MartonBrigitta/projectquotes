package org.fasttrackit.projectquotes.model;

import lombok.AllArgsConstructor;
import org.fasttrackit.projectquotes.service.BookRepository;
import org.fasttrackit.projectquotes.service.QuoteRepository;
import org.fasttrackit.projectquotes.service.SubjectRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Component
public class QuoteReader {

    private final SubjectRepository subjectRepository;
    private final BookRepository bookRepository;

    private final QuoteRepository quoteRepository;

    @Transactional
    public List<Quote> readAndSaveQuotes() {
        List<Quote> quotes = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/quotes.txt"));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                quotes.add(fromLine(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return quotes;
    }

    private Quote fromLine(String line) {
        String[] tokens = line.split("\\|");

        Book existingBook = bookRepository.findByTitle(tokens[1]);
        Book book = existingBook != null ? existingBook : new Book(tokens[0], tokens[1]);
        Subject existingSubject = subjectRepository.findByName(tokens[4]);
        Subject subject = existingSubject != null ? existingSubject : new Subject(tokens[4]);

        return quoteRepository.save(Quote.builder()
                .body(tokens[2])
                .favorite(Boolean.valueOf(tokens[3]))
                .subject(subject)
                .book(book)
                .build());
    }
}