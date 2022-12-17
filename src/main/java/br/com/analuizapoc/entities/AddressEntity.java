package br.com.analuizapoc.entities;

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
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
@Entity(name = "addresses")
@EntityListeners(AuditingEntityListener.class)
public class AddressEntity {

    private String cep;
    private String city;
    private String state;
    private String number;
    private String street;
    private String complement;
    private String neighborhood;

    @JsonIgnore
    private Boolean mainAddress;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @CreatedDate
    @Column(nullable = false, name = "DATE_CREATED")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreated;

    @LastModifiedDate
    @Column(name = "DATE_UPDATED")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateUpdated;
}