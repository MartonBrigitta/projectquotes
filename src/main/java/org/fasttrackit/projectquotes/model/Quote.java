package org.fasttrackit.projectquotes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Entity
@Builder
public class Quote {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String body;
    @Column
    private Boolean favourite;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST}) //SUBJECT_ID -> FK -> SUBJECT(ID)
    private Subject subject;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST}) //BOOK_ID -> FK -> BOOK(ID)
    private Book book;


    public Quote(String body, Boolean favourite, Subject subject,Book book) {
        this.body = body;
        this.favourite = favourite;
        this.subject = subject;
        this.book = book;
    }

}
