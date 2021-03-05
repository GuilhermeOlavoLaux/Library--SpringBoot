package com.br.libraryproject.controller;


import com.br.libraryproject.domain.Book;
import com.br.libraryproject.service.LibraryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "library")
@Log4j2
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

    @GetMapping(path = "/{id}") //http://localhost:8080/library/id
    public ResponseEntity<Book> findById(@PathVariable long id){
        return ResponseEntity.ok(libraryService.findById(id));
    }


    @GetMapping(path = "/findname") //http://localhost:8080/library/findname?name="book name"
    public ResponseEntity<List<Book>> findByName(@RequestParam String name){
        return ResponseEntity.ok(libraryService.findByName(name));
    }}

//
//    @GetMapping(path = "/findgenre") //http://localhost:8080/library/findgenre?genre="book genre"
//    public ResponseEntity<List<Book>> findByGenre(@RequestParam String genre){
//        return ResponseEntity.ok(libraryService.findByGenre(genre));
//    }
//
//    @GetMapping(path = "/findauthor") //http://localhost:8080/library/findauthor?author="book name"
//    public ResponseEntity<List<Book>> findByAuthor(@RequestParam String author){
//        return ResponseEntity.ok(libraryService.findByAuthor(author));
//    }
//
//}
