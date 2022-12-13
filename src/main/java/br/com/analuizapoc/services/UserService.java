package br.com.analuizapoc.services;

import br.com.analuizapoc.controllers.requests.UserRequestDto;
import br.com.analuizapoc.entities.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    void register(UserRequestDto userRequestDto);

    Optional<UserEntity> findById(UUID id);

    List<UserEntity> findAll();

    void deleteById(UUID id);

    void updateById(UUID id, UserRequestDto userRequestDto);
}
