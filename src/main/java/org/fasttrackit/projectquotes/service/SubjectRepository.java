package org.fasttrackit.projectquotes.service;

import org.fasttrackit.projectquotes.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository <Subject, Long> {
}
