package org.fasttrackit.projectquotes.service;

import lombok.AllArgsConstructor;
import org.fasttrackit.projectquotes.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects(String name) {
        return subjectRepository.filterSubjects(name);
    }

    public Subject add(Subject subject){
        subjectRepository.save(subject);
        return subject;
    }
}
