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
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public Subject addNewSubject (@RequestBody Subject subject) {
        return subjectService.add(subject);
    }

}
