package br.com.analuizapoc.repositories;

import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.enums.UserEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Page<UserEntity> findByDocumentType(UserEnum userEnum, Pageable pageable);
}