package br.com.analuizapoc.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "USER")
public class AddressEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    private UUID user;
    private String cep;
    private String city;
    private String state;
    private String street;
    private String number;
    private String district;
    private boolean principal;
    private String observation;
    private LocalDate datUpdate;
    private LocalDate datCreation;
}
