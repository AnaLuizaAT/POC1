package br.com.analuizapoc.controllers.responses;

import br.com.analuizapoc.enums.UserEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserResponse {
    private String email;
    private String telephone;
    private String document;
    private UserEnum documentType;
    private LocalDateTime dateUpdate;
    private LocalDateTime dateCreation;
}
