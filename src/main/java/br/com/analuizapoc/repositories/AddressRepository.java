package br.com.analuizapoc.repositories;

import br.com.analuizapoc.entities.AddressEntity;
import br.com.analuizapoc.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, UUID> {
    List<AddressEntity> findByUserOrderByDateCreated (UserEntity userEntity);
}