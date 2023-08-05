package org.fasttrackit.projectquotes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
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
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Subject subject;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Book book;

    public Quote(String body, Boolean favourite) {
        this.body = body;
        this.favourite = favourite;
    }

    public Quote(String body, Boolean favourite, Book book) {
        this.body = body;
        this.favourite = favourite;
        this.book = book;
    }
}
