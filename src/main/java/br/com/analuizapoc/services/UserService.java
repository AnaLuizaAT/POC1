package br.com.analuizapoc.services;

import br.com.analuizapoc.controllers.requests.UserRequest;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.enums.UserEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserService {

    UserEntity save(UserRequest userRequest);

    UserEntity findById(UUID id);

    Page<UserEntity> findAll(Pageable pageable);

    Page<UserEntity> findByDocumentType(UserEnum userEnum, Pageable pageable);

    UserEntity updateById(UUID id, UserRequest userRequest);

    void deleteById(UUID id);
}