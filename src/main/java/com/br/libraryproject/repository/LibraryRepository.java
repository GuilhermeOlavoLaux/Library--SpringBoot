package com.br.libraryproject.repository;

import com.br.libraryproject.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LibraryRepository extends JpaRepository<Book, Long> {

}
