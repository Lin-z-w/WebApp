package com.example.webapp.mapper;

import com.example.webapp.model.User;
import com.example.webapp.rest.dto.UserDto;

public class UserMapper {
    public static UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(user.getAddress());
        userDto.setImg(user.getImg());
        userDto.setPhone(user.getPhone());
        userDto.setBalance(user.getBalance());

        return userDto;
    }
}
