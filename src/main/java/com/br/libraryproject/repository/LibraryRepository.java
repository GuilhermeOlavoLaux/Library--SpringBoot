package com.br.libraryproject.repository;

import com.br.libraryproject.domain.Book;

import java.util.List;


public interface LibraryRepository {
    List<Book> listAll();
}
