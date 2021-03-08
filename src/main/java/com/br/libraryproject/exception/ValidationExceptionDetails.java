package com.br.libraryproject.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ValidationExceptionDetails extends SpringExceptionDetails {
    private final String fields;
    private final String fieldsMessage;
}
