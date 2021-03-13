package com.br.libraryproject.dtoRequests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BookPutRequestBody {
    @Schema(description = "This is the book Id", required = true)
    private Long id;

    @Schema(description = "This is the book name", example = "Harry Potter And The Prisoner Of Azkaban", required = true)
    @NotEmpty (message = "The book name cannot be empty")
    private String name;

    @Schema(description = "This is the book genre type", example = "Fantasy", required = true)
    @NotEmpty(message = "The book genre type cannot be empty")
    private String genre;

    @NotEmpty(message = "The book author cannot be empty")
    @Schema(description = "This is the author of the book", example = "J.K Rowling", required = true)
    private String author;




}
