package br.com.analuizapoc.controllers.responses;

import br.com.analuizapoc.entities.UserEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponse {
    private UserEntity user;
    private String cep;
    private String city;
    private String state;
    private String number;
    private String street;
    private String district;
    private boolean principal;
    private String observation;
}