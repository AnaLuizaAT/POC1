package br.com.analuizapoc.services;

import br.com.analuizapoc.controllers.requests.UserRequestDto;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public void register(UserRequestDto userRequestDto) {
        userRequestDto.setDateUpdate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        userRequestDto.setDateCreation(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        userRequestDto.setDocument(userRequestDto.getDocument().replaceAll("[^\\d ]", ""));
        userRequestDto.setTelephone(String.valueOf(Long.valueOf(userRequestDto.getTelephone().replaceAll("[^\\d ]", ""))));
        userRepository.save(mapper.map(userRequestDto, UserEntity.class));
    }

    public Optional<UserEntity> userById(UUID id) {
        return this.userRepository.findById(id);
    }
}