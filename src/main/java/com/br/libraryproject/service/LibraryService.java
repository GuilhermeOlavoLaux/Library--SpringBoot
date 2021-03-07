package com.br.libraryproject.service;

import com.br.libraryproject.domain.Book;
import com.br.libraryproject.dtoRequests.BookPostRequestBody;
import com.br.libraryproject.dtoRequests.BookPutRequestBody;
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

    public List<Book> findBookById(long id) {
        return libraryRepository.findBookById(id);
    }

    public Book findObjectIdOrThrowBadRequestException(long id) {
        return libraryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
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


    public void replace(BookPutRequestBody bookPutRequestBody) {
        Book savedAnime = findObjectIdOrThrowBadRequestException(bookPutRequestBody.getId());
        Book anime = Book.builder()
                .id(savedAnime.getId())
                .name(bookPutRequestBody.getName())
                .author(bookPutRequestBody.getAuthor())
                .genre(bookPutRequestBody.getGenre())
                .build();

        libraryRepository.save(anime);
    }


    public void delete(long id) {
        libraryRepository.delete(findObjectIdOrThrowBadRequestException(id));
    }

}
