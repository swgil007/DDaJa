package com.ddaja.ddaja.controller;

import com.ddaja.ddaja.domain.user.User;
import com.ddaja.ddaja.dto.UserDTO;
import com.ddaja.ddaja.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {

    private UserService userService;

    @RequestMapping("/")
    @GetMapping
    @ResponseBody
    public String test() {
        return "This Is Just Test";
    }
    @RequestMapping("/user/{id}")
    @ApiOperation(
        value = "사용자 정보 조회"
        , notes = "사용자의 ID를 통해 사용자의 정보를 조회한다.")
    @GetMapping
    @ResponseBody
    public UserDTO getUser(@PathVariable(name = "id") String id) {
        return userService.findUserInfoById(id);
    }
}
