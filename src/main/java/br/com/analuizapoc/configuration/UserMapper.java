package br.com.analuizapoc.configuration;

import br.com.analuizapoc.controllers.requests.UserRequestDto;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.repositories.UserRepository;

import java.util.UUID;

public class UserMapper {
    private UserRepository userRepository;

    public UserEntity toEntity(UserRequestDto userRequestDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userRequestDto.getEmail());
        userEntity.setDocument(userRequestDto.getDocument().replaceAll("[^\\d ]", ""));
        userEntity.setDocumentType(userRequestDto.getDocumentType());
        userEntity.setTelephone(Long.valueOf(userRequestDto.getTelephone().replaceAll("[^\\d ]", "")));
        return userEntity;
    }

    public UserEntity toEntityUpdate(UUID id, UserRequestDto userRequestDtoUpdate) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(RuntimeException::new);
        userEntity.setEmail(userRequestDtoUpdate.getEmail());
        userEntity.setDocument(userRequestDtoUpdate.getDocument());
        userEntity.setDocumentType(userRequestDtoUpdate.getDocumentType());
        userEntity.setTelephone(Long.valueOf(userRequestDtoUpdate.getTelephone()));
        return userRepository.save(userEntity);
    }
}