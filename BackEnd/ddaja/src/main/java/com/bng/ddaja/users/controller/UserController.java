package com.bng.ddaja.users.controller;

import java.io.IOException;

import javax.validation.Valid;

import com.bng.ddaja.common.config.exception.exception.MemberNotFoundException;
import com.bng.ddaja.common.config.exception.exception.NotAcceptableSocialLoginException;
import com.bng.ddaja.common.dto.CommonJWT;
import com.bng.ddaja.common.dto.CommonResource;
import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.common.dto.SocialAccessToken;
import com.bng.ddaja.common.hateoas.users.UserHateoas;
import com.bng.ddaja.users.dto.UserDTO;
import com.bng.ddaja.users.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;

@RequestMapping("users")
@AllArgsConstructor
@RestController
public class UserController {
    private UserService userService;
    
    @ApiOperation(
        value = "사용자 전체 조회"
        , notes = "전체 사용자 목록을 조회한다"
        , produces = "application/json"
        , response = CommonResponse.class
    )
    @GetMapping("")
    public ResponseEntity<CommonResponse> getUsers() {
        return ResponseEntity.ok().body(new CommonResponse(userService.getUsers()));
    }

    @ApiOperation(
        value = "사용자 단일 조회"
        , notes = "사용자 ID로 해당 사용자를 조회한다."
        , produces = "application/json"
        , response = CommonResponse.class
    )
    @GetMapping("{id}")
    public ResponseEntity<CommonResource> getUser(@PathVariable(name = "id", required = true) long id, CommonJWT commonJWT) {
        if(!commonJWT.isValidated()) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new CommonResource("Not Authorized Request"));
        return ResponseEntity.ok().body(new CommonResource(userService.getUserById(id)));
    }

    @PatchMapping("{id}")
    public ResponseEntity<CommonResponse> patchUser(@PathVariable(name = "id") long id, @RequestBody @Valid UserDTO userDTO) {
        userDTO.setId(id);
        userService.patchUserByUserDTO(userDTO);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("social")
    public ResponseEntity<CommonResource> createUserBySocial(@RequestBody SocialAccessToken socialAccessToken) throws MemberNotFoundException, NotAcceptableSocialLoginException, IOException {
        UserDTO userDTO = userService.getUserBySocialToken(socialAccessToken);
        if(userDTO.isCreated) return new ResponseEntity<>(new CommonResource(userDTO, UserHateoas.values()), HttpStatus.CREATED);
        return ResponseEntity.ok().body(new CommonResource(userDTO, UserHateoas.values()));
    }
}