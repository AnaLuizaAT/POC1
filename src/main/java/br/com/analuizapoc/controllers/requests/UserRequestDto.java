package br.com.analuizapoc.controllers.requests;

import br.com.analuizapoc.enums.UserEnum;
import lombok.Data;

@Data
public class UserRequestDto {
    private String email;
    private String telephone;
    private String document;
    private UserEnum documentType;
}