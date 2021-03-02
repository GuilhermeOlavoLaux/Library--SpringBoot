package com.br.libraryproject.controller;


import com.br.libraryproject.domain.Book;
import com.br.libraryproject.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "library")
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;


    @GetMapping
    public String initial(){
        String initial = "Project developed using Spring Boot";
        return initial;
    }

    @GetMapping(path = "list")
    public List<Book> list(){
        return libraryService.listAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable long id){
        return ResponseEntity.ok(libraryService.findById(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<Book> findByName(@RequestParam String name){
        return ResponseEntity.ok(libraryService.findByName(name));
    }

}
