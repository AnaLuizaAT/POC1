package br.com.analuizapoc.configuration;

import br.com.analuizapoc.controllers.requests.UserRequestDto;
import br.com.analuizapoc.entities.UserEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapper {
    private static final String removeMask = "[^\\d ]";

    public UserEntity toEntity(UserRequestDto userRequestDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userRequestDto.getEmail());
        userEntity.setDocument(userRequestDto.getDocument().replaceAll(removeMask, ""));
        userEntity.setDocumentType(userRequestDto.getDocumentType());
        userEntity.setTelephone(Long.valueOf(userRequestDto.getTelephone().replaceAll(removeMask, "")));
        return userEntity;
    }

    public UserEntity toUpdateEntity(UserRequestDto userUpdateDto, UserEntity userEntity) {
        userEntity.setEmail(userUpdateDto.getEmail());
        userEntity.setDocument(userUpdateDto.getDocument().replaceAll(removeMask, ""));
        userEntity.setDocumentType(userUpdateDto.getDocumentType());
        userEntity.setTelephone(Long.valueOf(userUpdateDto.getTelephone().replaceAll(removeMask, "")));
        return userEntity;
    }
}