package br.com.analuizapoc.controllers;

import br.com.analuizapoc.controllers.requests.UserRequest;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userServiceImplementation;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody UserRequest userRequest) {
        userServiceImplementation.register(userRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<UserEntity> getById(@PathVariable UUID id) {
        return userServiceImplementation.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> findAll() {
        return userServiceImplementation.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        userServiceImplementation.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateById(@PathVariable UUID id, @RequestBody UserRequest userRequest) {
        userServiceImplementation.updateById(id, userRequest);
    }
}