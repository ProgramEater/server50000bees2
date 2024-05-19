package org.server.fiftybees.mapper;

import org.server.fiftybees.controller.dto.UserProfileDto;
import org.server.fiftybees.controller.dto.UserRegisterDto;
import org.server.fiftybees.domain.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public User toUserEntity(UserProfileDto userProfileDto) {

        return User.builder()
                .id(userProfileDto.getId())
                .username(userProfileDto.getUsername())
                .email(userProfileDto.getEmail())
                .photoUrl(userProfileDto.getPhotoUrl())
                .build();
    }

    public User toUserEntity(UserRegisterDto userRegisterDto) {

        User user = User.builder()
                .username(userRegisterDto.getUsername())
                .password(userRegisterDto.getPassword())
                .email(userRegisterDto.getEmail())
                .build();

        if (userRegisterDto.getId() != null) user.setId(userRegisterDto.getId());

        return user;
    }

    public UserRegisterDto toUserRegisterDto(User user) {

        return UserRegisterDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getPassword())
                .build();
    }

    public UserProfileDto toUserProfileDto(User user) {

        return UserProfileDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .photoUrl(user.getPhotoUrl())
                .build();
    }
}
