package org.fasttrackit.projectquotes.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.fasttrackit.projectquotes.exception.ResourceNotFoundException;
import org.fasttrackit.projectquotes.model.Book;
import org.fasttrackit.projectquotes.model.Quote;
import org.fasttrackit.projectquotes.model.QuoteReader;
import org.fasttrackit.projectquotes.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuoteService {
    private final QuoteRepository quoteRepository;
    private final BookRepository bookRepository;
    private final QuoteReader quoteReader;

    @PostConstruct
    public void init(){
    List<Quote>quotes = quoteReader.readAndSaveQuotes();
    quoteRepository.saveAll(quotes);
    }

    public List <Quote> getAllQuotes(String body, Boolean favorite) {

        return quoteRepository.filterQuotes(body, favorite);
    }
    SubjectRepository subjectRepository;
    public Subject getBySubject (String subjectName){
        return subjectRepository.findByName(subjectName);
    }

    public Quote getById(long id) {
        return quoteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("quote not found",id));
    }

    public Quote delete (long id){
        Quote quote = getById(id);
        quoteRepository.deleteById(id);
        return quote;
    }

    public Quote add(Quote quote) {
        quoteRepository.save(quote);
        return quote;
    }

    public Quote update (Quote quote, long id){
        Quote existingQuote = delete(id);
        return add(Quote.builder()
                .id(id)
                .body(existingQuote.getBody())
                .favourite(quote.getFavourite())
                .build());
    }
}
