package com.example.webapp.rest;

import com.example.webapp.model.User;
import com.example.webapp.rest.api.LoginApi;
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
        User user = userService.findUserByUsername(loginUserRequestDto.getUsername());

        if (user != null && user.getPassword().equals(loginUserRequestDto.getPassword())) {
            // 登录成功，生成 JWT token
            String jwtToken = generateToken(loginUserRequestDto.getUsername(), user.getId());

            // 返回登录成功的响应
            LoginUser200ResponseDto responseDto = new LoginUser200ResponseDto();
            responseDto.setCode(1);
            responseDto.setData(jwtToken);
            return ResponseEntity.ok(responseDto);
        } else {
            // 登录失败，返回登录失败的响应
            LoginUser200ResponseDto responseDto = new LoginUser200ResponseDto();
            responseDto.setCode(0);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDto);
        }
    }
}
