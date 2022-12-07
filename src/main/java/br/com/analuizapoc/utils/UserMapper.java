package br.com.analuizapoc.utils;

import br.com.analuizapoc.controllers.requests.UserRequestDto;
import br.com.analuizapoc.entities.UserEntity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UserMapper {
    public UserEntity toEntity(UserRequestDto userRequestDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userRequestDto.getEmail());
        userEntity.setDocument(userRequestDto.getDocument().replaceAll("[^\\d ]", ""));
        userEntity.setDocumentType(userRequestDto.getDocumentType());
        userEntity.setTelephone(Long.valueOf(userRequestDto.getTelephone().replaceAll("[^\\d ]", "")));
        userEntity.setDateCreation(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return userEntity;
    }
}