package com.br.libraryproject.dtoRequests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BookPutRequestBody {
    private Long id;
    @NotEmpty (message = "The book name cannot be empty")
    private String name;
    @NotEmpty(message = "The book genre type cannot be empty")
    private String genre;
    private String author;




}
