package com.bng.ddaja.licenses.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bng.ddaja.licenses.repository.LicensesRepository;
import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.licenses.dto.LicenseDTO;
import com.bng.ddaja.licenses.dto.LicenseSearch;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service; 

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LicensesService {
    
    private LicensesRepository licensesRepository;

    public LicenseDTO getLicenseById(long id) {
        return new LicenseDTO(licensesRepository.findById(id));
    }

    public Page<LicenseDTO> getAllLicenseByLicenseSearch(LicenseSearch search) {
        return licensesRepository.findAll(search.toSpecification(), search.toPageable()).map(vo -> new LicenseDTO(vo));
    }

    public LicenseDTO saveLicense(LicenseDTO licenseDTO) {
        License licenseVO = licenseDTO.toEntity();
        licensesRepository.save(licenseVO);
        return new LicenseDTO(licenseVO);
    }

    public List<LicenseDTO> getAllLicenseLikeSubjectName(LicenseSearch licenseSearch) {
        return licensesRepository.findAll(licenseSearch.toSpecification()).stream().map(v -> new LicenseDTO(v)).collect(Collectors.toList());
    }

    public LicenseDTO findById( long lid ){
        return new LicenseDTO( licensesRepository.findById( lid ));
    }

    /** LICENSES LIST ALL **/
    public List<LicenseDTO> findAll(){

        List<LicenseDTO> list = new ArrayList<>();

        licensesRepository.findAll().forEach( x ->{ 
            list.add (new LicenseDTO( x ));
        });

        return list;
    }
}
