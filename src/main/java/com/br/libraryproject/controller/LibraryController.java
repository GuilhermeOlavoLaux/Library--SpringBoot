package com.br.libraryproject.controller;


import com.br.libraryproject.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "library")
@RequiredArgsConstructor
public class LibraryController {

    @GetMapping
    public String initial(){
        String initial = "Project developed using Spring Boot";
        return initial;
    }

    @GetMapping(path = "list")
    public List<Book> list(){
        return List.of(new Book(1,"Harry Potter","Fantasy"));
    }


}
