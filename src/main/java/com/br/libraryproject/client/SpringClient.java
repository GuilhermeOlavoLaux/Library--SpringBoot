package com.br.libraryproject.client;

import com.br.libraryproject.domain.Book;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Book> entity = new RestTemplate().getForEntity("http://localhost:8080/library/object/{id}",
                Book.class, 1);
        log.info(entity);



        Book object = new RestTemplate().getForObject("http://localhost:8080/library/object/{id}",
                Book.class, 1);
        log.info(object);



        Book[] books = new RestTemplate().getForObject("http://localhost:8080/library/list",
                Book[].class);
        log.info(Arrays.toString(books));



        ResponseEntity<List<Book>> exchange = new RestTemplate()
                .exchange("http://localhost:8080/library/list", HttpMethod.GET,
                        null, new ParameterizedTypeReference<List<Book>>() {});
        log.info(exchange);



        Book book2 = Book.builder().name("O mito da caverna").author("Platão").genre("Philosophy").build();
        // ID é gerado automaticamente
        ResponseEntity<Book> savedBook2 = new RestTemplate().exchange("http://localhost:8080/library/save",
                HttpMethod.POST, new HttpEntity<>(book2), Book.class);
        log.info("saved book2 {}", savedBook2);



        Book book3 = Book.builder().name("Harry Potter").author("J.K Rowling").genre("Fantasy").build();
        ResponseEntity<Book> book3Saved = new RestTemplate().exchange("http://localhost:8080/library/save",
                HttpMethod.POST,
                new HttpEntity<>(book3, createJsonHeader()),
                Book.class);
        log.info("saved book {}", book3Saved);



        Book bookToBeUpdated = book3Saved.getBody();
        bookToBeUpdated.setName("Harry Potter Updated");
        ResponseEntity<Void> bookUpdated = new RestTemplate().exchange("http://localhost:8080/library/replace",
                HttpMethod.PUT,
                new HttpEntity<>(bookToBeUpdated, createJsonHeader()),
                Void.class);
        log.info(bookUpdated);



        ResponseEntity<Void> bookDeleted = new RestTemplate().exchange("http://localhost:8080/library/delete/{id}",
                HttpMethod.DELETE,
                null,
                Void.class,
                bookToBeUpdated.getId());
        log.info(bookDeleted);

    }
    private static HttpHeaders createJsonHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
 }
