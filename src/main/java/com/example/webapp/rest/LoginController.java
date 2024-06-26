package com.example.webapp.rest;

import com.example.webapp.mapper.UserMapper;
import com.example.webapp.model.User;
import com.example.webapp.rest.api.LoginApi;
import com.example.webapp.rest.dto.LoginUser200ResponseDataDto;
import com.example.webapp.rest.dto.LoginUserRequestDto;
import com.example.webapp.rest.dto.LoginUser200ResponseDto;
import com.example.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.webapp.utils.JwtUtils.generateToken;

@RestController
public class LoginController implements LoginApi {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<LoginUser200ResponseDto> loginUser(@RequestBody LoginUserRequestDto loginUserRequestDto) {
        // 根据用户名查询用户
        System.out.println("loginUserRequestDto: " + loginUserRequestDto);
        User user = userService.findUserByUsername(loginUserRequestDto.getUsername());

        if (user != null && user.getPassword().equals(loginUserRequestDto.getPassword())) {
            System.out.println("登录成功");

            // 登录成功，生成 JWT token
            String jwtToken = generateToken(loginUserRequestDto.getUsername());

            // 返回登录成功的响应
            LoginUser200ResponseDto responseDto = new LoginUser200ResponseDto();
            responseDto.setCode(1);
            LoginUser200ResponseDataDto data = new LoginUser200ResponseDataDto();
            data.setToken(jwtToken);
            data.setUserInfo(UserMapper.userToDto(user));
            responseDto.setData(data);
            return ResponseEntity.ok(responseDto);
        } else {
            System.out.println("登录失败");

            // 登录失败，返回登录失败的响应
            LoginUser200ResponseDto responseDto = new LoginUser200ResponseDto();
            responseDto.setCode(0);
            return ResponseEntity.status(401).body(responseDto);
        }
    }
}
