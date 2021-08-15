package com.bng.ddaja.temp.license;

import java.util.ArrayList;
import java.util.List;

import com.bng.ddaja.test.dto.LicenseDTO;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TempLicensesService {

    private TempLicensesRepository licensesRepository;
    
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
