package com.example.webapp.rest;

import com.example.webapp.model.User;
import com.example.webapp.rest.api.RegisterApi;
import com.example.webapp.rest.dto.LoginUser200ResponseDto;
import com.example.webapp.rest.dto.LoginUserRequestDto;
import com.example.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController implements RegisterApi {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<LoginUser200ResponseDto> registerUser(@RequestBody LoginUserRequestDto loginUserRequestDto) {
        String username = loginUserRequestDto.getUsername();
        String password = loginUserRequestDto.getPassword();

        boolean registered = userService.registerUser(new User("", username, password));

        if (registered) {
            // 注册成功，返回成功响应
            return ResponseEntity.ok(new LoginUser200ResponseDto().code(1).data("User registered successfully."));
        } else {
            // 用户名已存在，返回失败响应
            return ResponseEntity.badRequest().body(new LoginUser200ResponseDto().code(0).data("Username already exists."));
        }
    }
}
