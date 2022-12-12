package br.com.analuizapoc.controllers;

import br.com.analuizapoc.controllers.requests.UserRequestDto;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody UserRequestDto userRequestDto) {
        userService.register(userRequestDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<UserEntity> getById(@PathVariable UUID id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateById(@PathVariable UUID id, @RequestBody UserRequestDto userRequestDto) {
        userService.updateById(id, userRequestDto);
    }
}