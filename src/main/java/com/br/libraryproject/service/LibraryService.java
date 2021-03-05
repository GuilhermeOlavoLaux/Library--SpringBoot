package com.br.libraryproject.service;

import com.br.libraryproject.domain.Book;
import com.br.libraryproject.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;


    public List<Book> listAll() {
        return libraryRepository.findAll();
    }

    public Book findById(long id) {
        return libraryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book not Found"));
    }

    public List<Book> findByName(String name) {
        return libraryRepository.findByName(name);
    }

    public List<Book> findByGenre(String genre){
        return libraryRepository.findByGenre(genre);
    }

    public List<Book> findByAuthor(String author){
        return libraryRepository.findByAuthor(author);
    }

}
