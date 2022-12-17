package br.com.analuizapoc.controllers.v1;

import br.com.analuizapoc.controllers.mappers.UserMapper;
import br.com.analuizapoc.controllers.requests.UserRequest;
import br.com.analuizapoc.controllers.responses.UserResponse;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static br.com.analuizapoc.controllers.mappers.UserMapper.toDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse save(@Valid @RequestBody UserRequest userRequest) {
        return toDto(userService.save(userRequest));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse findById(@PathVariable UUID id) {
        return toDto(userService.findById(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> findAll() {
        List<UserEntity> entityList = userService.findAll();
        return entityList.stream().map(UserMapper::toDto).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserResponse updateById(@PathVariable UUID id, @RequestBody UserRequest userRequest) {
        return toDto(userService.updateById(id, userRequest));
    }
}