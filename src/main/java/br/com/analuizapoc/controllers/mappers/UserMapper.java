package br.com.analuizapoc.controllers.mappers;

import br.com.analuizapoc.controllers.requests.UserRequest;
import br.com.analuizapoc.controllers.responses.UserResponse;
import br.com.analuizapoc.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

@Configuration
@AllArgsConstructor
public class UserMapper {
    private static final String removeMask = "[^\\d ]";

    public static UserResponse toDto(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
        userResponse.setEmail(userEntity.getEmail());
        userResponse.setDocument(userEntity.getDocument());
        userResponse.setTelephone(userResponse.getTelephone());
        userEntity.setDateUpdated(userResponse.getDateUpdated());
        userResponse.setDocumentType(userEntity.getDocumentType());
        userResponse.setDateCreated(userResponse.getDateCreated());
        userResponse.setAddressResponseList(userEntity.getAddressList().stream().map(AddressMapper::toAddressDto).collect(Collectors.toList()));
        return userResponse;
    }

    public UserEntity toEntity(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setDocumentType(userRequest.getDocumentType());
        userEntity.setDocument(userRequest.getDocument().replaceAll(removeMask, ""));
        userEntity.setTelephone(Long.valueOf(userRequest.getTelephone().replaceAll(removeMask, "")));
        return userEntity;
    }

    public UserEntity toUpdateEntity(UserRequest userUpdate, UserEntity userEntity) {
        userEntity.setEmail(userUpdate.getEmail());
        userEntity.setDocumentType(userUpdate.getDocumentType());
        userEntity.setDocument(userUpdate.getDocument().replaceAll(removeMask, ""));
        userEntity.setTelephone(Long.valueOf(userUpdate.getTelephone().replaceAll(removeMask, "")));
        return userEntity;
    }
}