package com.bng.ddaja.admin.service;

import com.bng.ddaja.admin.dto.AdminDTO;
import com.bng.ddaja.admin.repository.AdminRepository;
import static com.bng.ddaja.admin.spec.AdminSpec.*;
import static org.springframework.data.jpa.domain.Specification.where;

import java.util.Optional;

import com.bng.ddaja.common.config.exception.exception.MemberNotFoundException;
import com.bng.ddaja.common.domain.Admin;
import com.bng.ddaja.common.dto.TokenPair;
import com.bng.ddaja.common.spec.SpecBuilder;
import com.bng.ddaja.tokens.service.TokenService;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class AdminService {
    private AdminRepository adminRepository;
    private TokenService tokenService;

    public AdminDTO loginAdminByAdminDTO(AdminDTO adminDTO) {
        Specification<Admin> adminSpec = SpecBuilder.builder(Admin.class)
                                                    .addSpec(where(loginIDEqual(adminDTO.getLoginID())))
                                                    .addSpec(where(passWordEqual(adminDTO.getPassWord())))
                                                    .toSpecification();
        Optional<Admin> admin = adminRepository.findOne(adminSpec);
        if(!admin.isPresent()) throw new MemberNotFoundException("해당되는 관리자 계정이 없습니다.");
        AdminDTO result = new AdminDTO(admin.get());
        result.setTokenPair(tokenService.getTokenPair(result));
        return result;
    }
}
