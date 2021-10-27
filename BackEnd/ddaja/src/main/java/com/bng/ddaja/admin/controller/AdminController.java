package com.bng.ddaja.admin.controller;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public ResponseEntity<AdminDTO> loginAdmin(@RequestBody @Valid AdminDTO adminDTO, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt", "gillog");
        cookie.setMaxAge(7 * 24 * 60 * 60);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);
        Cookie[] cookies = request.getCookies();
        Arrays.stream(cookies).forEach(c -> {
            log.info(c.getName() + c.getValue());
        });
        return ResponseEntity.ok().body(adminService.loginAdminByAdminDTO(adminDTO));
    }
}
