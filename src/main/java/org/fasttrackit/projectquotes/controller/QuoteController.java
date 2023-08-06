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

    @GetMapping("/{id}")
    public Quote getById(@PathVariable long id){
        return quoteService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Quote deleteById(@PathVariable long id) {
        return quoteService.delete(id);
    }

    @PostMapping
    public Quote addNewQuote (@RequestBody Quote quote) {
        return quoteService.add(quote);
    }

    @PutMapping("/{id}")
    public  Quote updateQuote(@RequestBody Quote quote, @PathVariable long id){
        return quoteService.update(quote,id);
    }
}
