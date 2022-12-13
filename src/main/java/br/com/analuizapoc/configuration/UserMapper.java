package br.com.analuizapoc.configuration;

import br.com.analuizapoc.controllers.requests.UserRequest;
import br.com.analuizapoc.entities.UserEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapper {
    private static final String removeMask = "[^\\d ]";

    public UserEntity toEntity(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setDocument(userRequest.getDocument().replaceAll(removeMask, ""));
        userEntity.setDocumentType(userRequest.getDocumentType());
        userEntity.setTelephone(Long.valueOf(userRequest.getTelephone().replaceAll(removeMask, "")));
        return userEntity;
    }

    public UserEntity toUpdateEntity(UserRequest userUpdateDto, UserEntity userEntity) {
        userEntity.setEmail(userUpdateDto.getEmail());
        userEntity.setDocument(userUpdateDto.getDocument().replaceAll(removeMask, ""));
        userEntity.setDocumentType(userUpdateDto.getDocumentType());
        userEntity.setTelephone(Long.valueOf(userUpdateDto.getTelephone().replaceAll(removeMask, "")));
        return userEntity;
    }
}