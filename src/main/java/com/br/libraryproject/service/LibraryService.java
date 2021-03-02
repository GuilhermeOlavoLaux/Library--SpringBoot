package com.br.libraryproject.service;

import com.br.libraryproject.domain.Book;
import com.br.libraryproject.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private static List<Book> books;
    static {
        books = new ArrayList<>(List.of(new Book(1L,"Harry Potter E A Pedra Filosofal","J.K. Rowling", "Fantasy"),
                new Book(2L,"O estrangeiro", "Albert Camus", "Philosophy")));
    }

    public List<Book> listAll(){
        return books;
    }

    public Book findById(long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not Found"));
    }

    public Book findByName(String name) {
        return books.stream()
                .filter(book -> book.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not Found"));
    }



}
