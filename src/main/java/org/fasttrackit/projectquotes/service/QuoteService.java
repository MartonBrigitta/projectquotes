package org.fasttrackit.projectquotes.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
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
    quoteReader.readAndSaveQuotes();
    }

    public List <Quote> getAllQuotes(String body, Boolean favorite) {

        return quoteRepository.filterQuotes(body, favorite);
    }
    SubjectRepository subjectRepository;
    public Subject getBySubject (String subjectName){
        return subjectRepository.findByName(subjectName);
    }

    public Quote add(Quote quote) {
        quoteRepository.save(quote);
        return quote;
    }
}
