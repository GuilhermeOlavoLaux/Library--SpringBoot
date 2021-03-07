package com.br.libraryproject.controller;


import com.br.libraryproject.domain.Book;
import com.br.libraryproject.dtoRequests.BookPostRequestBody;
import com.br.libraryproject.dtoRequests.BookPutRequestBody;
import com.br.libraryproject.service.LibraryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "library")
@Log4j2
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;




    @GetMapping(path = "list")
    public List<Book> list(){
        return libraryService.listAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<Book>> findById(@PathVariable long id){
        return ResponseEntity.ok(libraryService.findBookById(id));
    }


    @GetMapping(path = "/findname")
    public ResponseEntity<List<Book>> findByName(@RequestParam String name){
        return ResponseEntity.ok(libraryService.findByName(name));
    }

    @GetMapping(path = "/findgenre")
    public ResponseEntity<List<Book>> findByGenre(@RequestParam String genre){
        return ResponseEntity.ok(libraryService.findByGenre(genre));
    }

    @GetMapping(path = "/findauthor")
    public ResponseEntity<List<Book>> findByAuthor(@RequestParam String author){
        return ResponseEntity.ok(libraryService.findByAuthor(author));
}

    @GetMapping(path = "/findgenreauthor")
    public ResponseEntity<List<Book>> findByGenreAndAuthor(@RequestParam String genre, String author){
        return ResponseEntity.ok(libraryService.findByGenreAndAuthor(genre, author));
    }

    @GetMapping(path = "/findnameauthor")
    public ResponseEntity<List<Book>> findByNameAndAuthor(@RequestParam String name, String author){
        return ResponseEntity.ok(libraryService.findByNameAndAuthor(name, author));
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Book> save(@RequestBody BookPostRequestBody bookPostRequestBody){
        return new ResponseEntity<>(libraryService.save(bookPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping(path = "/replace")
    public ResponseEntity<Void> replace(@RequestBody BookPutRequestBody bookPutRequestBody){
        libraryService.replace(bookPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        libraryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
