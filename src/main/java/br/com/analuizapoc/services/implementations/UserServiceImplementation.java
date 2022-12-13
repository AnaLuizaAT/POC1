package br.com.analuizapoc.services.implementations;

import br.com.analuizapoc.configuration.UserMapper;
import br.com.analuizapoc.controllers.requests.UserRequestDto;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.repositories.UserRepository;
import br.com.analuizapoc.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public void register(UserRequestDto userRequestDto) {
        UserEntity userEntity = userMapper.toEntity(userRequestDto);
        userRepository.save(userEntity);
    }

    @Override
    public Optional<UserEntity> findById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateById(UUID id, UserRequestDto userRequestDto) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(RuntimeException::new);
        userRepository.save(userMapper.toUpdateEntity(userRequestDto, userEntity));
    }
}