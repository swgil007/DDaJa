package com.bng.ddaja.users.controller;

import com.bng.ddaja.common.dto.CommonResource;
import com.bng.ddaja.common.dto.CommonResponse;
import com.bng.ddaja.users.service.UsersService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
}
