package com.example.webapp.rest;

import com.example.webapp.rest.api.SettingsApi;
import com.example.webapp.rest.dto.GetSettings200ResponseInnerDto;
import com.example.webapp.rest.dto.GetSettings200ResponseInnerSettingsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class SettingsController implements SettingsApi {
    @Override
    public ResponseEntity<List<GetSettings200ResponseInnerDto>> getSettings() {
        // 创建 settings 对象
        GetSettings200ResponseInnerSettingsDto settingsDto = new GetSettings200ResponseInnerSettingsDto();
        settingsDto.setApp("Standalone Point of Sale");
        settingsDto.setStore("Store-Pos");
        settingsDto.setAddressOne("10086");
        settingsDto.setAddressTwo("10087");
        settingsDto.setContact("15968774896");
        settingsDto.setTax("");
        settingsDto.setSymbol("$");
        settingsDto.setPercentage("10");
        settingsDto.setFooter("");
        settingsDto.setImg("");

        // 创建 responseDto 对象并设置 settings
        GetSettings200ResponseInnerDto responseDto = new GetSettings200ResponseInnerDto();
        responseDto.setSettings(settingsDto);
        responseDto.setId("d36d");

        return ResponseEntity.ok(Collections.singletonList(responseDto));
    }
}
