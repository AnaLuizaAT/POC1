package br.com.analuizapoc.services;

import br.com.analuizapoc.controllers.requests.UserRequest;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.repositories.UserRepository;
import br.com.analuizapoc.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper = new UserMapper();
    public void register(UserRequest userRequest) {
        UserEntity userEntity = userMapper.toEntity(userRequest);
        userRepository.save(userEntity);
    }
    public Optional<UserEntity> findById(UUID id) {
        return userRepository.findById(id);
    }
}