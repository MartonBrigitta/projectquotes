package org.fasttrackit.projectquotes.model;

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
    @Column
    private String title;
    @Column
    private String author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Quote> quotes;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
