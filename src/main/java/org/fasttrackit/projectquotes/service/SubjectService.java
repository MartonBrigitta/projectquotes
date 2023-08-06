package org.fasttrackit.projectquotes.service;

import lombok.AllArgsConstructor;
import org.fasttrackit.projectquotes.exception.ResourceNotFoundException;
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

    public Subject getById(long id){
        return subjectRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("subject not found",id));
    }

    public  Subject delete(long id){
        Subject subject = getById(id);
        subjectRepository.deleteById(id);
        return subject;
    }

    public Subject update (Subject subject, long id){
        return add(Subject.builder()
                .id(id)
                .name(subject.getName())
                .build());
    }
}
