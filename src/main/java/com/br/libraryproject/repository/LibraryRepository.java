package com.br.libraryproject.repository;

import com.br.libraryproject.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LibraryRepository extends JpaRepository<Book, Long> {
    List<Book> findByName(String name);
}


