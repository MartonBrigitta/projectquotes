package org.fasttrackit.projectquotes.controller;

import lombok.AllArgsConstructor;
import org.fasttrackit.projectquotes.model.Quote;
import org.fasttrackit.projectquotes.service.BookRepository;
import org.fasttrackit.projectquotes.service.QuoteRepository;
import org.fasttrackit.projectquotes.service.QuoteService;
import org.fasttrackit.projectquotes.service.SubjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    @GetMapping
    public List<Quote> getAll(@RequestParam(required = false)String body,
                              @RequestParam(required = false)Boolean favourite){
        return quoteService.getAllQuotes(body, favourite);
    }

    @PostMapping
    public Quote addNewQuote (@RequestBody Quote quote) {
        return quoteService.add(quote);
    }
}
