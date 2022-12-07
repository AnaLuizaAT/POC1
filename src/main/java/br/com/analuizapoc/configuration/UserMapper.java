package br.com.analuizapoc.configuration;

import br.com.analuizapoc.controllers.requests.UserRequestDto;
import br.com.analuizapoc.entities.UserEntity;

public class UserMapper {
    public UserEntity toEntity(UserRequestDto userRequestDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userRequestDto.getEmail());
        userEntity.setDocument(userRequestDto.getDocument().replaceAll("[^\\d ]", ""));
        userEntity.setDocumentType(userRequestDto.getDocumentType());
        userEntity.setTelephone(Long.valueOf(userRequestDto.getTelephone().replaceAll("[^\\d ]", "")));
        return userEntity;
    }
}