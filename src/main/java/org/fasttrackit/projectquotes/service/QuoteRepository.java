package org.fasttrackit.projectquotes.service;

import org.fasttrackit.projectquotes.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository <Quote, Long> {
}
