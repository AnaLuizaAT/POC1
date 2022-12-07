package br.com.analuizapoc.controllers.requests;

import br.com.analuizapoc.enums.UserEnum;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class UserRequestDto {
    private String email;

    @NotEmpty(message = "The user telephone cannot be empty")
    private String telephone;

    private String document;
    private UserEnum documentType;
    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;
}