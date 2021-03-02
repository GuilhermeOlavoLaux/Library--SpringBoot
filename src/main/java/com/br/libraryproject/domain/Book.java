package com.br.libraryproject.domain;



public class Book {
    public Long id;
    public String name;
    public String author;
    public String genre;

    public Book(Long id, String name, String author, String genre) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.genre = genre;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
