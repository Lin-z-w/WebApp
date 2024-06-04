package com.example.webapp.rest;

import com.example.webapp.rest.api.UserApi;
import com.example.webapp.rest.dto.CreateOrder200ResponseDto;
import com.example.webapp.rest.dto.GetUserInfo200ResponseDto;
import com.example.webapp.rest.dto.UpdateUserInfoRequestDto;
import org.springframework.http.ResponseEntity;

public class UserController implements UserApi {
    @Override
    public ResponseEntity<GetUserInfo200ResponseDto> getUserInfo(String username) {
        return UserApi.super.getUserInfo(username);
    }

    @Override
    public ResponseEntity<CreateOrder200ResponseDto> updateUserInfo(UpdateUserInfoRequestDto updateUserInfoRequestDto) {
        return UserApi.super.updateUserInfo(updateUserInfoRequestDto);
    }
}
