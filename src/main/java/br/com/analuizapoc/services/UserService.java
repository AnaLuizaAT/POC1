package br.com.analuizapoc.services;

import br.com.analuizapoc.controllers.requests.UserRequest;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void registerUser(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setDocument(userRequest.getDocument().replaceAll("[^\\d ]", ""));
        userEntity.setDocumentType(userRequest.getDocumentType());
        userEntity.setTelephone(userRequest.getTelephone().replaceAll("[^\\d ]", ""));
        userRepository.save(userEntity);
    }
}