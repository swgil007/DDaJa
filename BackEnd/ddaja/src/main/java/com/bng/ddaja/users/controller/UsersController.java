package com.bng.ddaja.users.controller;

import java.io.IOException;

import com.bng.ddaja.common.dto.CommonResource;
import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.common.dto.SocialAccessToken;
import com.bng.ddaja.common.util.OKHttp;
import com.bng.ddaja.users.service.UsersService;

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
import okhttp3.Request;

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
    public ResponseEntity<CommonResponse> createUserBySocial(@RequestBody SocialAccessToken socialAccessToken) throws IOException {
        log.info(socialAccessToken.toString());
        
        Request request = new Request.Builder()
        .addHeader("Authorization", "Bearer " + socialAccessToken.getAccessToken())
        .url("https://kapi.kakao.com/v2/user/me")
        .get()
        .build();

        log.info(OKHttp.getResponseBody(request));


        return ResponseEntity.ok().body(null);
    }
}
