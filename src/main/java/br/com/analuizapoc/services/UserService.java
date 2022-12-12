package br.com.analuizapoc.services;

import br.com.analuizapoc.configuration.UserMapper;
import br.com.analuizapoc.controllers.requests.UserRequestDto;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public void register(UserRequestDto userRequestDto) {
        UserEntity userEntity = userMapper.toEntity(userRequestDto);
        userRepository.save(userEntity);
    }

    public Optional<UserEntity> findById(UUID id) {
        return userRepository.findById(id);
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    public void updateById(UUID id, UserRequestDto userRequestDto) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(RuntimeException::new);
        userRepository.save(userMapper.toUpdateEntity(userRequestDto, userEntity));
    }
}