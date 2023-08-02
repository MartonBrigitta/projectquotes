package org.fasttrackit.projectquotes.model;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class QuoteReader {

    public List<Quote> readQuotes() {
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

        Book book = new Book(tokens[0], tokens[1]);
        Subject subject = new Subject(tokens[4]);
        return Quote.builder()
                .body(tokens[2])
                .favorite(Boolean.valueOf(tokens[3]))
                .subject(subject)
                .book(book)
                .build();
    }
}