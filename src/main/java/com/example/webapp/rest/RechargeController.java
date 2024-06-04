package com.example.webapp.rest;

import com.example.webapp.rest.api.RechargeApi;
import com.example.webapp.rest.dto.Recharge200ResponseDto;
import com.example.webapp.rest.dto.RechargeRequestDto;
import com.example.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RechargeController implements RechargeApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<Recharge200ResponseDto> recharge(RechargeRequestDto rechargeRequestDto) {
        userService.recharge(rechargeRequestDto.getUsername(),rechargeRequestDto.getAmount());
        return ResponseEntity.ok(new Recharge200ResponseDto());
    }
}
