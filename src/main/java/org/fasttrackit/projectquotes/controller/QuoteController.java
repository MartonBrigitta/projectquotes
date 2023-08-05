package org.fasttrackit.projectquotes.controller;

import lombok.AllArgsConstructor;
import org.fasttrackit.projectquotes.model.Quote;
import org.fasttrackit.projectquotes.service.QuoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    @GetMapping
    public List<Quote> getAllQuotes(){
        return quoteService.getAllQuotes();
    }

    @PostMapping
    public Quote addNewQuote (@RequestBody Quote quote) {
        return quoteService.add(quote);
    }
}
