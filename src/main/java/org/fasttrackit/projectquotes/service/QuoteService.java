package org.fasttrackit.projectquotes.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.fasttrackit.projectquotes.model.Quote;
import org.fasttrackit.projectquotes.model.QuoteReader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuoteService {
    private final QuoteRepository quoteRepository;
    private final QuoteReader quoteReader;

    @PostConstruct
    public void init() {
        quoteRepository.saveAll(quoteReader.readQuotes());
    }

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }
}
