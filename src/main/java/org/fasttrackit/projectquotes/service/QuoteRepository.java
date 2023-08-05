package org.fasttrackit.projectquotes.service;

import org.fasttrackit.projectquotes.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository <Quote, Long> {

    @Query("Select q from Quote q where (:body=null or lower(q.body) like lower(concat('%',:body, '%')))" +
    "and (:favourite IS NULL OR q.favourite = :favourite)")
    List<Quote> filterQuotes(@Param("body")String body,
                             @Param("favourite")Boolean favourite);
}
