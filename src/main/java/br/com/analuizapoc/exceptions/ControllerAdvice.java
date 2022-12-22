package br.com.analuizapoc.exceptions;

import br.com.analuizapoc.controllers.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MainAddressException.class)
    public ResponseEntity<ErrorResponse> MainAddressException(MainAddressException exception, WebRequest request) {
        ErrorResponse response = new ErrorResponse();
        response.setPath(request.getDescription(false));
        response.setInternalCode(exception.getErrorCode());
        response.setHttpCode(HttpStatus.CONFLICT.value());
        response.setMessage(exception.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
