package com.br.libraryproject.controller;


import com.br.libraryproject.domain.Book;
import com.br.libraryproject.dtoRequests.BookPostRequestBody;
import com.br.libraryproject.dtoRequests.BookPutRequestBody;
import com.br.libraryproject.repository.LibraryRepository;
import com.br.libraryproject.service.LibraryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "library")
@Log4j2
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;
    private final LibraryRepository libraryRepository;

    @GetMapping(path = "list")
    @Operation (summary = "Return all books in a list")
    public List<Book> listAllNonPageable(){
        return libraryService.listAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    @Operation (summary = "Delete a book by Id")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "204", description = "Successful Operation"),
            @ApiResponse(responseCode = "400", description = "When book doesn't exist in the database")

    })
    public ResponseEntity<Void> delete(@PathVariable long id){
        libraryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @Operation (summary = "Return all books paginated", description = "The default size is 20 books per page, use the" +
            " parameter size to change the default value ")
    public Page<Book> list(@ParameterObject Pageable pageable){
        return libraryRepository.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    @Operation (summary = "Return a book by Id in a list")
    public ResponseEntity<List<Book>> findById(@PathVariable long id){
        return ResponseEntity.ok(libraryService.findBookById(id));
    }

    @GetMapping(path = "/object/{id}")
    @Operation (summary = "Return a book by Id (A object book)")
    public ResponseEntity<Book> findBookObjectByIdOrThrowBadRequestException(@PathVariable long id){
        return ResponseEntity.ok(libraryService.findBookObjectByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    @Operation (summary = "Return a book by name in a list")
    public ResponseEntity<List<Book>> findByName(@RequestParam String name){
        return ResponseEntity.ok(libraryService.findByName(name));
    }

    @GetMapping(path = "/find/genre")
    @Operation (summary = "Return a book by genre in a list")
    public ResponseEntity<List<Book>> findByGenre(@RequestParam String genre){
        return ResponseEntity.ok(libraryService.findByGenre(genre));
    }

    @GetMapping(path = "/find/author")
    @Operation (summary = "Return a book by author in a list")
    public ResponseEntity<List<Book>> findByAuthor(@RequestParam String author){
        return ResponseEntity.ok(libraryService.findByAuthor(author));
}

    @GetMapping(path = "/find/genre/author")
    @Operation (summary = "Return a book by author and by genre in a list")
    public ResponseEntity<List<Book>> findByGenreAndAuthor(@RequestParam String genre, String author){
        return ResponseEntity.ok(libraryService.findByGenreAndAuthor(genre, author));
    }

    @GetMapping(path = "/find/name/author")
    @Operation (summary = "Return a book by name and by author in a list")
    public ResponseEntity<List<Book>> findByNameAndAuthor(@RequestParam String name, String author){
        return ResponseEntity.ok(libraryService.findByNameAndAuthor(name, author));
    }

    @PostMapping(path = "/save")
    @Operation (summary = "Post a new book")
    public ResponseEntity<Book> save(@RequestBody @Valid BookPostRequestBody bookPostRequestBody){
        return new ResponseEntity<>(libraryService.save(bookPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping(path = "/replace")
    @Operation (summary = "Replace a book")
    public ResponseEntity<Void> replace(@RequestBody @Valid BookPutRequestBody bookPutRequestBody){
        libraryService.replace(bookPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
