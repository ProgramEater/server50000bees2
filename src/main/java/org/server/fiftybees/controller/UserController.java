package org.server.fiftybees.controller;

import org.server.fiftybees.controller.dto.UserProfileDto;
import org.server.fiftybees.controller.dto.UserRegisterDto;
import org.server.fiftybees.domain.Authority;
import org.server.fiftybees.exception.UserNotAuthorisedException;
import org.server.fiftybees.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserProfileDto add(@RequestBody UserRegisterDto userRegisterDto) {
        return userService.add(userRegisterDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UserProfileDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserProfileDto getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserProfileDto update(@PathVariable Long id, @RequestBody UserProfileDto userProfileDto) {
        return userService.update(id, userProfileDto);
    }

    @PutMapping("/authority/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody Authority authority) {
        userService.update(id, authority);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable long id) {
        userService.deleteById(id);
    }

    @GetMapping("/username/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UserProfileDto getByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserProfileDto login(Authentication authentication) {
        if (authentication == null) throw new UserNotAuthorisedException("User not authorised");
        return userService.getByUsername(authentication.getName());
    }
}
