package br.com.analuizapoc.entities;

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
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ADDRESSES")
@EntityListeners(AuditingEntityListener.class)
public class AddressEntity {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @Column(nullable = false)
    private String cep;

    @Column
    private String city;

    @Column
    private String state;

    @Column(nullable = false)
    private String number;

    @Column
    private String street;

    @Column
    private String district;

    @Column(nullable = false)
    private boolean principal;

    @Column
    private String observation;

    @Column
    @LastModifiedDate
    private LocalDateTime dateUpdate;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime dateCreation;
}