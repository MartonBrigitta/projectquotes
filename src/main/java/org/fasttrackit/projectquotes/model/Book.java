package org.fasttrackit.projectquotes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.websocket.OnClose;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String title;
    @Column
    private String author;

    @JsonIgnore
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Quote> quotes;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
