package com.ddaja.ddaja.controller;

import com.ddaja.ddaja.domain.user.User;
import com.ddaja.ddaja.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping
    @ResponseBody
    public User getUser(@PathVariable(name = "id") String id) {
        return userService.findUserInfoById(id);
    }
}
