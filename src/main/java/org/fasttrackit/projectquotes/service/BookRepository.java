package org.fasttrackit.projectquotes.service;

import org.fasttrackit.projectquotes.model.Book;
import org.fasttrackit.projectquotes.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {



    @Query("select b from Book b where b.title=:name")
    Book findByTitle(@Param("name") String name);
}
