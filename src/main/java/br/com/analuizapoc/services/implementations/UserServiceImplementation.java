package br.com.analuizapoc.services.implementations;

import br.com.analuizapoc.controllers.mappers.UserMapper;
import br.com.analuizapoc.controllers.requests.UserRequest;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.repositories.UserRepository;
import br.com.analuizapoc.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserEntity save(UserRequest userRequest) {
        UserEntity userEntity = userMapper.toEntity(userRequest);
        return userRepository.save(userEntity);
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findById(UUID id) {
        return userRepository.getReferenceById(id);
    }

    public UserEntity updateById(UUID id, UserRequest userRequest) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(RuntimeException::new);
        return userRepository.save(userMapper.toUpdateEntity(userRequest, userEntity));
    }
}