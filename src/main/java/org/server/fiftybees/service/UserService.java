package org.server.fiftybees.service;

import org.server.fiftybees.controller.dto.UserProfileDto;
import org.server.fiftybees.controller.dto.UserRegisterDto;
import org.server.fiftybees.domain.Authority;

import java.util.List;

public interface UserService {
    UserProfileDto add(UserRegisterDto userRegisterDto);

    List<UserProfileDto> getAll();

    UserProfileDto getById(long id);

    UserProfileDto getByUsername(String username);

    UserProfileDto update(Long id, UserProfileDto userProfileDto);

    void update(Long id, Authority authority);

    void deleteById(long id);
}
