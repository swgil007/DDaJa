package com.bng.ddaja.licenses.service;


import java.util.List;
import java.util.stream.Collectors;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.licenses.dto.LicenseDTO;
import com.bng.ddaja.licenses.repository.LicensesRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LicensesService {

    private LicensesRepository licensesRepository;
    
    public List<LicenseDTO> getAllLicenses() {
        List<License> voList = licensesRepository.findAll();
        return voList.stream().map(vo -> new LicenseDTO(vo)).collect(Collectors.toList());
    }

}