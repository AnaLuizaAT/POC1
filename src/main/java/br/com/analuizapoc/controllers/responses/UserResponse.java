package br.com.analuizapoc.controllers.responses;

import br.com.analuizapoc.enums.UserEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserResponse {
    private String email;
    private Long telephone;
    private String document;
    private UserEnum documentType;
    private LocalDate datUpdate;
    private LocalDate datCreation;

    public void setTelephone(Long telephone) {
        this.telephone = Long.valueOf(Long.toString(telephone));
    }
}
