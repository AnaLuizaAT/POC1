package br.com.analuizapoc.controllers.v1;

import br.com.analuizapoc.controllers.mappers.UserMapper;
import br.com.analuizapoc.controllers.requests.UserRequest;
import br.com.analuizapoc.controllers.responses.UserResponse;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.enums.UserEnum;
import br.com.analuizapoc.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import java.util.UUID;

import static br.com.analuizapoc.controllers.mappers.UserMapper.toDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
@EnableWebMvc
@EnableSpringDataWebSupport
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse save(@Valid @RequestBody UserRequest userRequest) {
        return toDto(userService.save(userRequest));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<UserResponse> findAll(@PageableDefault(size = 5, direction = Sort.Direction.ASC, sort = "id") Pageable pageable) {
        Page<UserEntity> entityList = userService.findAll(pageable);
        return entityList.map(UserMapper::toDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse findById(@PathVariable UUID id) {
        return toDto(userService.findById(id));
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public Page<UserEntity> findByDocumentType(@RequestParam String documentType, @PageableDefault(size = 5, direction = Sort.Direction.ASC, sort = "id") Pageable pageable) {
        UserEnum userEnum = UserEnum.valueOf(documentType.toUpperCase());
        return userService.findByDocumentType(userEnum, pageable);
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