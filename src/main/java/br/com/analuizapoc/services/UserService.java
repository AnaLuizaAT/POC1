package br.com.analuizapoc.services;

import br.com.analuizapoc.controllers.requests.UserRequest;
import br.com.analuizapoc.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserService {

    void deleteById(UUID id);

    Page<UserEntity> findAll(Pageable pageable);

    UserEntity findById(UUID id);

    UserEntity save(UserRequest userRequest);

    UserEntity updateById(UUID id, UserRequest userRequest);
}
