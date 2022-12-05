package br.com.analuizapoc.entities;

import br.com.analuizapoc.enums.UserEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    private String email;
    private Long telephone;
    private String document;
    private UserEnum documentType;
    private LocalDate datUpdate;
    private LocalDate datCreation;
}