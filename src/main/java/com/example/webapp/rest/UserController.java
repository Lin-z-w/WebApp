package com.example.webapp.rest;

import com.example.webapp.mapper.UserMapper;
import com.example.webapp.model.User;
import com.example.webapp.rest.api.UserApi;
import com.example.webapp.rest.dto.*;
import com.example.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UpdateUserInfo200ResponseDto> getUserInfo(String username) {
        System.out.println("getUserInfo");
        User user = userService.findUserByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(new UpdateUserInfo200ResponseDto().code(0), HttpStatus.NOT_FOUND);
        }
        UserDto userDto = UserMapper.userToDto(user);
        System.out.println(userDto);
        return new ResponseEntity<>(new UpdateUserInfo200ResponseDto().code(1).data(userDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UpdateUserInfo200ResponseDto> updateUserInfo(UpdateUserInfoRequestDto updateUserInfoRequestDto) {
        System.out.println("updateUserInfo");

        String username = updateUserInfoRequestDto.getUsername();
        String email = updateUserInfoRequestDto.getEmail();
        String address = updateUserInfoRequestDto.getAddress();
        String phone = updateUserInfoRequestDto.getPhone();
        String img = updateUserInfoRequestDto.getImg();

        System.out.println("username: " + username);
        System.out.println("email: " + email);
        System.out.println("address: " + address);
        System.out.println("phone: " + phone);
        System.out.println("img: " + img);

        User user =userService.updateUserInfo(username, email, address, phone, img);

        return new ResponseEntity<>(new UpdateUserInfo200ResponseDto().code(1).data(UserMapper.userToDto(user)), HttpStatus.OK);
    }
}
