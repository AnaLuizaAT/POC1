package br.com.analuizapoc.services;

import br.com.analuizapoc.controllers.requests.UserRequest;
import br.com.analuizapoc.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {

    void deleteById(UUID id);

    List<UserEntity> findAll();

    UserEntity findById(UUID id);

    UserEntity save(UserRequest userRequest);

    UserEntity updateById(UUID id, UserRequest userRequest);
}
