package br.com.analuizapoc.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String path;
    private String message;
    private Integer httpCode;
    private String internalCode;
    private LocalDateTime timestamp;
    private List<FieldErrorResponse> errors;
}
