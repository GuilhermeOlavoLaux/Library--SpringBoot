package com.br.libraryproject.repository;

import com.br.libraryproject.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Book, Long> {

    List<Book> findBookById(long id);
    List<Book> findByName(String name);
    List<Book> findByGenre(String genre);
    List<Book> findByAuthor(String author);
    List<Book> findByGenreAndAuthor(String genre, String author);
    List<Book> findByNameAndAuthor(String name, String author);


}


