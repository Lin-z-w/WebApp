package com.example.webapp.rest;

import com.example.webapp.model.User;
import com.example.webapp.rest.api.RegisterApi;
import com.example.webapp.rest.dto.CreateOrder200ResponseDto;
import com.example.webapp.rest.dto.RegisterUserRequestDto;
import com.example.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController implements RegisterApi {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<CreateOrder200ResponseDto> registerUser(RegisterUserRequestDto registerUserRequestDto) {
        System.out.println("Registering user with request: " + registerUserRequestDto);
        String username = registerUserRequestDto.getUsername();
        String password = registerUserRequestDto.getPassword();
        String email = registerUserRequestDto.getEmail();
        String address = registerUserRequestDto.getAddress();
        String phone = registerUserRequestDto.getPhone();
        String defaultImage = "https://img0.baidu.com/it/u=1849651366,4275781386&fm=253&fmt=auto&app=138&f=JPEG?w=585&h=500";
        System.out.println("Registering user: " + username);
        System.out.println("Password: " + password);

        // 调用 UserService 注册用户
        boolean registered = userService.registerUser(new User(username, password, email, address, defaultImage, phone, 0));

        if (registered) {
            // 注册成功，返回成功响应
            System.out.println("User registered successfully.");
            return ResponseEntity.ok(new CreateOrder200ResponseDto().code(1));
        } else {
            // 用户名已存在，返回失败响应
            System.out.println("Username already exists.");
            return ResponseEntity.badRequest().body(new CreateOrder200ResponseDto().code(0));
        }
    }
}
