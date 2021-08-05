package com.bng.ddaja.licenses.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bng.ddaja.common.domain.License;
import com.bng.ddaja.licenses.repository.LicensesRepository;
import com.bng.ddaja.licenses.dto.LicenseDTO;
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

    public LicenseDTO getLicenseById(long id) {
        return new LicenseDTO(licensesRepository.findById(id));
    }

    public LicenseDTO saveLicense(LicenseDTO licenseDTO) {
        License licenseVO = licenseDTO.toEntity();
        licensesRepository.save(licenseVO);
        return new LicenseDTO(licenseVO);
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
