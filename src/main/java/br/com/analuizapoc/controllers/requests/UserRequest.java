package br.com.analuizapoc.controllers.requests;

import br.com.analuizapoc.enums.UserEnum;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class UserRequest {
    @NotNull(message = "The user email cannot be null")
    @NotEmpty(message = "The user email cannot be empty")
    private String email;

    @NotNull(message = "The user email cannot be null")
    @NotEmpty(message = "The user email cannot be empty")
    private String telephone;

    @NotNull(message = "The user email cannot be null")
    @NotEmpty(message = "The user email cannot be empty")
    private String document;

    @Enumerated
    @NotNull(message = "The user email cannot be null")
    private UserEnum documentType;

    @CreatedDate
    @Column(name="DT_CREATION", nullable = false)
    private LocalDateTime date_creation;

    @LastModifiedDate
    @Column(name="DT_UPDATE")
    private LocalDateTime date_update;
}
