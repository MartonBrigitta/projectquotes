package org.fasttrackit.projectquotes.controller;

import lombok.AllArgsConstructor;
import org.fasttrackit.projectquotes.model.Book;
import org.fasttrackit.projectquotes.model.Subject;
import org.fasttrackit.projectquotes.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public List<Subject> getAll(@RequestParam(required = false)String name){
        return subjectService.getAllSubjects(name);
    }

    @PostMapping
    public Subject addNewSubject (@RequestBody Subject subject) {
        return subjectService.add(subject);
    }

    @GetMapping("/{id}")
    public Subject getById(@PathVariable long id) {
        return subjectService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Subject deleteById(@PathVariable long id){
        return subjectService.delete(id);
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@RequestBody Subject subject, @PathVariable long id){
        return subjectService.update(subject,id);
    }

}
