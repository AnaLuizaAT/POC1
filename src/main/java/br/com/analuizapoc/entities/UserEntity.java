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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    @Column
    @NotBlank(message = "The User Email cannot be blank")
    private String email;

    @Column
    @NotNull(message = "The user telephone cannot be null")
    private Long telephone;

    @Column
    @NotBlank(message = "The User Document cannot be blank")
    private String document;

    @Column
    @Enumerated
    @NotNull(message = "The user document type cannot be null")
    private UserEnum documentType;

    @Column
    @LastModifiedDate
    private LocalDateTime dateUpdate;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime dateCreation;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AddressEntity> addressList = new ArrayList<>();
}