package org.fasttrackit.projectquotes.service;

import org.fasttrackit.projectquotes.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {
}
