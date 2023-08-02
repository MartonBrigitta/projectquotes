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
    private Boolean favorite;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Subject subject;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Book book;

    public Quote(String body, Boolean favorite) {
        this.body = body;
        this.favorite = favorite;
    }

    public Quote(String body, Boolean favorite, Book book) {
        this.body = body;
        this.favorite = favorite;
        this.book = book;
    }
}
