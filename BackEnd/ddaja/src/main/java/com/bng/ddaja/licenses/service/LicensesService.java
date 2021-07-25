package com.bng.ddaja.licenses.service;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.licenses.repository.LicensesRepository;
import com.bng.ddaja.test.dto.LicenseDTO;

import org.springframework.stereotype.Service; 

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LicensesService {
    
    private LicensesRepository repository;

    public License findById( long lid ){
        return  repository.findById(lid);
    }
}
