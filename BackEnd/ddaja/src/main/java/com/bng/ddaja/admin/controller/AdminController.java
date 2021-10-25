package com.bng.ddaja.admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("admin")
@AllArgsConstructor
@RestController
public class AdminController {
    
    @PostMapping("login")
    public ResponseEntity<String> loginAdmin() {
        return ResponseEntity.ok().body("TEST");
    }
}
