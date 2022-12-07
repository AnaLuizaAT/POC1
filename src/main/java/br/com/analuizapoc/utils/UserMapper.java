package br.com.analuizapoc.utils;

import br.com.analuizapoc.controllers.requests.UserRequest;
import br.com.analuizapoc.entities.UserEntity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UserMapper {
    public UserEntity toEntity(UserRequest userRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setDocument(userRequest.getDocument().replaceAll("[^\\d ]", ""));
        userEntity.setDocumentType(userRequest.getDocumentType());
        userEntity.setTelephone(Long.valueOf(userRequest.getTelephone().replaceAll("[^\\d ]", "")));
        userEntity.setDateCreation(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return userEntity;
    }
}
