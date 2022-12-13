package br.com.analuizapoc.controllers.requests;

import br.com.analuizapoc.entities.UserEntity;
import lombok.Data;

@Data
public class AddressRequestDto {
    private String cep;
    private String number;
    private UserEntity userId;
}