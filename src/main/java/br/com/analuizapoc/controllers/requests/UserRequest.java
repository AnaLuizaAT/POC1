package br.com.analuizapoc.controllers.requests;

import br.com.analuizapoc.enums.UserEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank
    @Email(message = "Invalid email")
    @Length(max = 100, message = "Email must be a maximum of 100 characters")
    private String email;

    @NotBlank
    private String document;

    @NotBlank
    private String telephone;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserEnum documentType;

    private List<AddressRequest> addressRequestList = new ArrayList<>();
}