package br.com.analuizapoc.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MainAddressException extends RuntimeException {
    private final String message;
    private final String errorCode;
}

