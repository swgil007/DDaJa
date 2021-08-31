package com.bng.ddaja.users.controller;

import java.io.IOException;
import java.util.Date;

import com.bng.ddaja.common.api.KaKaoResponse;
import com.bng.ddaja.common.dto.CommonDTO;
import com.bng.ddaja.common.dto.CommonResource;
import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.common.dto.SocialAccessToken;
import com.bng.ddaja.common.enums.HttpMethods;
import com.bng.ddaja.common.util.OKHttp;
import com.bng.ddaja.users.service.UsersService;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
@RequestMapping("users")
@AllArgsConstructor
@RestController
public class UsersController {
    private UsersService usersService;
    
    @ApiOperation(
        value = "사용자 전체 조회"
        , notes = "전체 사용자 목록을 조회한다"
        , produces = "application/json"
        , response = CommonResponse.class
    )
    @GetMapping("")
    public ResponseEntity<CommonResponse> getUsers() {
        return ResponseEntity.ok().body(new CommonResponse(usersService.getUsers()));
    }

    @ApiOperation(
        value = "사용자 단일 조회"
        , notes = "사용자 ID로 해당 사용자를 조회한다."
        , produces = "application/json"
        , response = CommonResponse.class
    )
    @GetMapping("{id}")
    public ResponseEntity<CommonResource> getUser(@PathVariable(name = "id", required = true) long id) {
        return ResponseEntity.ok().body(new CommonResource(usersService.getUserById(id)));
    }

    @PostMapping("social")
    public ResponseEntity<CommonDTO> createUserBySocial(@RequestBody SocialAccessToken socialAccessToken) throws IOException {
        log.info(socialAccessToken.toString());
        
        return ResponseEntity.ok().body(usersService.getUserBySocialToken(socialAccessToken));
    }
}
