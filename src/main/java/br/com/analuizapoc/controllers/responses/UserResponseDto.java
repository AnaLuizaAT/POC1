package br.com.analuizapoc.controllers.responses;

import br.com.analuizapoc.enums.UserEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    private String email;
    private Long telephone;
    private String document;
    private UserEnum documentType;
}