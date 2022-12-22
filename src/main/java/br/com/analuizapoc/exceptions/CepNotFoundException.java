package br.com.analuizapoc.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CepNotFoundException extends RuntimeException {
    private final String message;
    private final String errorCode;
}
