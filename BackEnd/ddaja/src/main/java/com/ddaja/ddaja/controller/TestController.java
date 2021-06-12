package com.ddaja.ddaja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    
    @RequestMapping("/")
    @GetMapping
    @ResponseBody
    public String home() {
        return "This Is Just Home";
    }

    @RequestMapping("/test")
    @GetMapping
    public String test() {
        return "view/test";
    }
}
