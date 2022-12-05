package br.com.analuizapoc.controllers.requests;

import br.com.analuizapoc.enums.UserEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRequest {
    private String email;
    private Long telephone;
    private String document;
    private UserEnum documentType;
    private LocalDate datUpdate;
    private LocalDate datCreation;

}
