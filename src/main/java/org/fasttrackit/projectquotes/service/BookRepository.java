package org.fasttrackit.projectquotes.service;

import org.fasttrackit.projectquotes.model.Book;
import org.fasttrackit.projectquotes.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {

    @Query("select b from Book b where b.title=:name")
    Book findByTitle(@Param("name") String name);

    @Query("select b from Book b where (:title = null or lower (b.title) like lower(concat('%',:title,'%'))) " +
            "and (:author = null or lower(b.author) like lower(concat('%', :author,'%')))")
    List<Book> filterBooks(@Param("title")String title,
                           @Param("author")String author);


}
