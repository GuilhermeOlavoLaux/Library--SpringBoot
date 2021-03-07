package com.br.libraryproject.dtoRequests;

import lombok.Data;

@Data
public class BookPutRequestBody {
    private Long id;
    private String name;
    private String genre;
    private String author;




}
