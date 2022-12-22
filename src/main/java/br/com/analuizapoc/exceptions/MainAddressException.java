package br.com.analuizapoc.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MainAddressException extends RuntimeException {
    private String message;
    private String errorCode;
}

