package com.br.libraryproject.service;

import com.br.libraryproject.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private static List<Book> books = new ArrayList<>(List.of(
            new Book(1L,"Harry Potter","J.K. Rowling", "Fantasy"),
            new Book(2L,"O estrangeiro", "Albert Camus", "Philosophy"),
            new Book(3L,"O Mito De Sisífo", "Albert Camus", "Philosophy")));


    public List<Book> listAll(){
        return books;
    }

    public List<Book> findById(long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id)).collect(Collectors.toList());
    }

    public List<Book> findByName(String name) {
        return books.stream()
                .filter(book -> book.getName().equals(name)).collect(Collectors.toList());
    }

    public List<Book> findByGenre(String genre){
        return books.stream()
                .filter(book -> book.getGenre().equals(genre)).collect(Collectors.toList());
    }
    public List<Book> findByAuthor(String author){
        return books.stream()
                .filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }



}
