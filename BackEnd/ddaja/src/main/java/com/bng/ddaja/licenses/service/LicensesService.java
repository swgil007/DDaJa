package com.bng.ddaja.licenses.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bng.ddaja.licenses.repository.LicensesRepository;
import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.common.dto.CommonPage;
import com.bng.ddaja.common.dto.CommonSearch;
import com.bng.ddaja.licenses.dto.LicenseDTO;
import com.bng.ddaja.licenses.dto.LicenseSearch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service; 

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LicensesService {
    
    private LicensesRepository licensesRepository;

    public List<LicenseDTO> getAllLicenses() {
        return licensesRepository.findAll()
                                .stream()
                                .map(vo -> new LicenseDTO(vo))
                                .collect(Collectors.toList());
    }

    public Page<LicenseDTO> getAllLicensesByPage(Pageable pageable) {
        // Page<License> voPage = licensesRepository.findAll(pageable);
        // List<LicenseDTO> licenseDTOList = voPage.getContent().stream().map(v -> new LicenseDTO(v)).collect(Collectors.toList());
        // Page<LicenseDTO> dtoPage = new PageRequest<LicenseDTO>();
        return licensesRepository.findAll(pageable).map(vo -> new LicenseDTO(vo));
    }
    public LicenseDTO getLicenseById(long id) {
        return new LicenseDTO(licensesRepository.findById(id));
    }

    public Page<LicenseDTO> getAllLicensesBySearchAndPage(LicenseSearch licenseSearch, CommonPage page) {
        return licensesRepository.findAll(licenseSearch.toSpecification(), page.toPageable()).map(vo -> new LicenseDTO(vo));
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
