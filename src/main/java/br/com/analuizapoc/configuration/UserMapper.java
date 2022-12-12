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

    public UserEntity toUpdateEntity(UUID id, UserRequestDto userUpdateDto) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(RuntimeException::new);
        userEntity.setEmail(userUpdateDto.getEmail());
        userEntity.setDocument(userUpdateDto.getDocument());
        userEntity.setDocumentType(userUpdateDto.getDocumentType());
        userEntity.setTelephone(Long.valueOf(userUpdateDto.getTelephone()));
        return userEntity;
    }
}