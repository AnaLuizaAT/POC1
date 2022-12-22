package br.com.analuizapoc.controllers.requests;

import br.com.analuizapoc.enums.UserEnum;
import br.com.analuizapoc.validation.CnpjGroup;
import br.com.analuizapoc.validation.CpfGroup;
import br.com.analuizapoc.validation.UserGroupSequenceProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

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
@GroupSequenceProvider(UserGroupSequenceProvider.class)
public class UserRequest {

    @NotBlank
    @Email(message = "Invalid email")
    @Length(max = 100, message = "Email must be a maximum of 100 characters")
    private String email;

    @NotBlank
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    private String document;

    @NotBlank
    private String telephone;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserEnum documentType;

    private List<AddressRequest> addressRequestList = new ArrayList<>();
}