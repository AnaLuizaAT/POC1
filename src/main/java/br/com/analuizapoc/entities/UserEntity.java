package br.com.analuizapoc.entities;

import br.com.analuizapoc.enums.UserEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @NotBlank(message = "The User Email cannot be blank")
    private String email;

    @NotNull(message = "The user telephone cannot be null")
    private Long telephone;

    @NotBlank(message = "The User Document cannot be blank")
    private String document;

    @Enumerated(EnumType.STRING)
    @Column(name = "DOCUMENT_TYPE")
    @NotNull(message = "The user document type cannot be null")
    private UserEnum documentType;

    @CreatedDate
    @Column(nullable = false, name = "DATE_CREATED")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreated;

    @LastModifiedDate
    @Column(name = "DATE_UPDATED")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateUpdated;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AddressEntity> addressList = new ArrayList<>();
}