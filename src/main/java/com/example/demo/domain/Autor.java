package com.example.demo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Autor {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "autors")
    private Set<Books> books = new HashSet<>();

    public Autor(String name) {
        this.name = name;
        this.books = books;
    }

    public Autor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }
}
