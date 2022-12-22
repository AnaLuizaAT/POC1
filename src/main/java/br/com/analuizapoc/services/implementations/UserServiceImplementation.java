package br.com.analuizapoc.services.implementations;

import br.com.analuizapoc.controllers.mappers.UserMapper;
import br.com.analuizapoc.controllers.requests.UserRequest;
import br.com.analuizapoc.entities.AddressEntity;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.enums.UserEnum;
import br.com.analuizapoc.exceptions.MainAddressException;
import br.com.analuizapoc.repositories.UserRepository;
import br.com.analuizapoc.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    public UserEntity findById(UUID id) {
        return userRepository.findById(id).orElseThrow(MainAddressException::new);
    }

    public Page<UserEntity> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public UserEntity save(UserRequest userRequest) {
        UserEntity userEntity = userMapper.toEntity(userRequest);
        return userRepository.save(userEntity);
    }

    public UserEntity updateById(UUID id, UserRequest userRequest) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(RuntimeException::new);
        return userRepository.save(userMapper.toUpdateEntity(userRequest, userEntity));
    }

    public Page<UserEntity> findByDocumentType(UserEnum userEnum, Pageable pageable) {
        return userRepository.findByDocumentType(userEnum, pageable);
    }

    public List<AddressEntity> findAddressByUserId(UUID id) {
        var user = findById(id);
        return user.getAddressList();
    }
}