package com.example.webapp.rest;

import com.example.webapp.mapper.UserMapper;
import com.example.webapp.model.User;
import com.example.webapp.rest.api.UserApi;
import com.example.webapp.rest.dto.CreateOrder200ResponseDto;
import com.example.webapp.rest.dto.GetUserInfo200ResponseDto;
import com.example.webapp.rest.dto.UpdateUserInfoRequestDto;
import com.example.webapp.rest.dto.UserDto;
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
    public ResponseEntity<GetUserInfo200ResponseDto> getUserInfo(String username) {
        System.out.println("getUserInfo");
        User user = userService.findUserByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(new GetUserInfo200ResponseDto().code(0), HttpStatus.NOT_FOUND);
        }
        UserDto userDto = UserMapper.userToDto(user);
        System.out.println(userDto);
        return new ResponseEntity<>(new GetUserInfo200ResponseDto().code(1).data(userDto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateOrder200ResponseDto> updateUserInfo(UpdateUserInfoRequestDto updateUserInfoRequestDto) {
        System.out.println("updateUserInfo");

        String username = updateUserInfoRequestDto.getUsername();
        String password = updateUserInfoRequestDto.getPassword();
        String email = updateUserInfoRequestDto.getEmail();
        String address = updateUserInfoRequestDto.getAddress();
        String phone = updateUserInfoRequestDto.getPhone();
        String img = updateUserInfoRequestDto.getImg();

        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("email: " + email);
        System.out.println("address: " + address);
        System.out.println("phone: " + phone);
        System.out.println("img: " + img);

        userService.updateUserInfo(username, password, email, address, phone, img);

        return new ResponseEntity<>(new CreateOrder200ResponseDto().code(1), HttpStatus.OK);
    }
}
