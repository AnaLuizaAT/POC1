package br.com.analuizapoc.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ADDRESS")
public class AddressEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private UserEntity users;

    private String cep;
    private String city;
    private String state;
    private String number;
    private String street;
    private String district;
    private boolean principal;
    private String observation;
    private LocalDateTime dateUpdate;
    private LocalDateTime dateCreation;
}
