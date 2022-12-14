package br.com.analuizapoc.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    private UUID userId;
    private String observation;
    private Boolean isMain = false;

    @NotBlank
    private String number;
}