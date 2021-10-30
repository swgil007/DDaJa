package com.bng.ddaja.admin.controller;

import java.util.Arrays;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.bng.ddaja.admin.dto.AdminDTO;
import com.bng.ddaja.admin.service.AdminService;
import com.bng.ddaja.common.util.CookieUtil;

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
    public ResponseEntity<AdminDTO> loginAdmin(@RequestBody @Valid AdminDTO adminDTO, HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        CookieUtil.setJwtCookieInResponse(response, "jwttest");
        log.info("getTokenInCookie ==" + CookieUtil.getTokenInCookie(request));
        return ResponseEntity.ok().body(adminService.loginAdminByAdminDTO(adminDTO));
    }
}
