package com.br.libraryproject.service;

import com.br.libraryproject.domain.Book;
import com.br.libraryproject.dtoRequests.BookPostRequestBody;
import com.br.libraryproject.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public List<Book> listAll() {
        return libraryRepository.findAll();
    }

    public List<Book> findById(long id) {
        return libraryRepository.findBookById(id);
    }
    public Book findObjectById(long id) {
        return libraryRepository.findObjectById(id);
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

    public List<Book>findByGenreAndAuthor(String genre, String author){
        return libraryRepository.findByGenreAndAuthor(genre,author);
    }

    public List<Book>findByNameAndAuthor(String name, String author){
        return libraryRepository.findByNameAndAuthor(name,author);
    }
    public  Book save(BookPostRequestBody bookPostRequestBody) {
        return libraryRepository.save(Book.builder()
                .name(bookPostRequestBody.getName())
                .genre(bookPostRequestBody.getGenre())
                .author(bookPostRequestBody.getAuthor())
                .build());
    }
    public void delete(long id) {
        libraryRepository.delete(findObjectById(id));
    }

}
