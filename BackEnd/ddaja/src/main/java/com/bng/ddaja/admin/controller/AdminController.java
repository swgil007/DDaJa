package com.bng.ddaja.admin.controller;

import javax.validation.Valid;

import com.bng.ddaja.admin.dto.AdminDTO;
import com.bng.ddaja.admin.service.AdminService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("admin")
@AllArgsConstructor
@RestController
public class AdminController {

    private AdminService adminService;
    
    @PostMapping("login")
    public ResponseEntity<AdminDTO> loginAdmin(@RequestBody @Valid AdminDTO adminDTO) {
        return ResponseEntity.ok().body(adminService.loginAdminByAdminDTO(adminDTO));
    }
}
