package br.com.analuizapoc.repositories;

import br.com.analuizapoc.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {
}