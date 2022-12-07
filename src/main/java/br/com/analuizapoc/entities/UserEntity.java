package br.com.analuizapoc.entities;

import br.com.analuizapoc.enums.UserEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "USERS")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @NotNull(message = "The user email cannot be null")
    @NotEmpty(message = "The user email cannot be empty")
    private String email;

    @NotNull(message = "The user telephone cannot be null")
    private Long telephone;

    @NotNull(message = "The user email cannot be null")
    @NotEmpty(message = "The user email cannot be empty")
    private String document;

    @Enumerated
    @NotNull(message = "The user email cannot be null")
    private UserEnum documentType;

    @CreatedDate
    @Column(name = "DT_CREATION", nullable = false)
    private LocalDateTime dateCreation;

    @LastModifiedDate
    @Column(name = "DT_UPDATE")
    private LocalDateTime dateUpdate;
}