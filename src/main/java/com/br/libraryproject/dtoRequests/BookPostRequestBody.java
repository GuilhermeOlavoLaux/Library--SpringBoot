package com.br.libraryproject.dtoRequests;

import lombok.Data;

@Data
public class BookPostRequestBody {
    private String name;
    private String genre;
    private String author;
}