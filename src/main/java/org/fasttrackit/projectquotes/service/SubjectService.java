package org.fasttrackit.projectquotes.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.fasttrackit.projectquotes.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public List <Subject> getAllSubjectes(){
        return subjectRepository.findAll();
    }
}